package tower.nsp.bo.stat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;

import tower.nsp.db.DbResourceClass;
import tower.nsp.db.DbSysOrg;
import tower.nsp.en.EnResourceClass;
import tower.nsp.en.EnSysOrg;
import tower.tmvc.ErrorException;
import tower.tmvc.QueryResult;
import tower.tmvc.QueryResultRow;
import tower.tmvc.RootBo;
import tower.tmvc.Transaction;
import tower.tmvc.XMLWrap;

/**
 * 
 * 功能概述：库存统计
 * 
 * @author fanlj 2008-10-18 下午06:07:54
 */
public class AmountStatList implements RootBo {

	@SuppressWarnings("unchecked")
	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		// TODO Auto-generated method stub

		/***********************************************************************
		 * 声明变量
		 **********************************************************************/

		DbSysOrg dbSysOrg;
		EnSysOrg enSysOrg;
		Vector classes;

		DbResourceClass resourceClass;
		EnResourceClass enResourceClass;
		QueryResult rsClass;
		QueryResultRow row;

		QueryResult rsAmount;
		QueryResultRow rowAmount;

		List<List> classList = new ArrayList<List>(); 				//存放每个类型下的所有型号的信息
		HashMap<String,List> classMap = new HashMap<String,List>();	//存放所有的类型
		List classFor = new ArrayList();//存放所有的类别

		// 获取参数：
		String orgId;

		List<String> org = new ArrayList<String>();					//存放所有的分公司的名字

		/***********************************************************************
		 * 获取输入
		 **********************************************************************/
		orgId = sessionXml.getItemValue("SYS_USER", 1, "USER_ORG_ID");

		/***********************************************************************
		 * 创建数据库连接、实例化DB、EN
		 **********************************************************************/
		transaction.createDefaultConnection(null, true);
		dbSysOrg = new DbSysOrg(transaction, null);
		resourceClass = new DbResourceClass(transaction, null);

		/***********************************************************************
		 * 执行业务逻辑、输出
		 **********************************************************************/
		//判断机构id是否为空
		if (orgId != null && orgId.length() > 0) {
			enSysOrg = dbSysOrg.findByKey(orgId);
			
			//判断机构是否查找到
			if (enSysOrg != null) {
				String sqlClass = "select * from resource_class, resource_type"
						+ " where resource_class.class_id = resource_type.resource_class_id"
						+ " order by resource_class.class_id asc, resource_type.type_id asc;";
				rsClass = transaction.doQuery(null, sqlClass);
				
				if (rsClass == null || rsClass.size() == 0) {
					// 分公司没有资源
					throw new ErrorException("AS0001", null);
				}
				//统计资源类型
				classes = resourceClass.findAll();
				for(int i = 0 ; i < classes.size() ; i ++){
					enResourceClass = (EnResourceClass) classes.get(i);
					classFor.add(enResourceClass.getClassId());
				}
				if (enSysOrg.getParentId() != null
						&& enSysOrg.getParentId().length() > 0) {
					//将公司name存放到列表中
					org.add(enSysOrg.getOrgName());
					
					//根据型号遍历，统计出各个型号的库存
					for (int i = 0; i < rsClass.size(); i++) {
						row = rsClass.get(i);
						if (row != null) {
							String typeId = row.getString("TYPE_ID");
							//根据条件拼写sql语句
							String sqlAmount = "select ifnull(sum(online_amount),0) online , ifnull(sum(stock_amount),0) amount ,  " 
									+ "ifnull(sum(incons_amount),0) incons ,"
									+ "ifnull(sum(BAD_AMOUNT),0) bad"
									+ " from resource_org_amount, sys_org"
									+ " where resource_org_amount.org_id = sys_org.org_id"
									+ " and resource_org_amount.resource_type_id = '" + typeId
									+ " ' and (resource_org_amount.org_id = '"+ enSysOrg.getOrgId() 
									+ " ' or sys_org.parent_id = '" + enSysOrg.getOrgId()+ "')";
							rsAmount = transaction.doQuery(null, sqlAmount);
							List<String> typeList = new ArrayList<String>();
							//添加类别名称和型号名称
							typeList.add(row.getString("CLASS_NAME"));
							typeList.add(row.getString("TYPE_NAME"));
							//判断查找到的记录是否为空如果没空则填写0
							if (rsAmount != null) {
								rowAmount = rsAmount.get(0);
								//判断行集是否为空如果为空则填写0
								if (rowAmount != null) {
									typeList.add(enSysOrg.getOrgId()+","+row.getString("TYPE_ID")+",1,"+rowAmount.getString("online"));
									typeList.add(enSysOrg.getOrgId()+","+row.getString("TYPE_ID")+",2,"+rowAmount.getString("amount"));
									typeList.add(enSysOrg.getOrgId()+","+row.getString("TYPE_ID")+",3,"+rowAmount.getString("incons"));
									typeList.add(enSysOrg.getOrgId()+","+row.getString("TYPE_ID")+",4,"+rowAmount.getString("bad"));
								} else {
									typeList.add("0");
									typeList.add("0");
									typeList.add("0");
									typeList.add("0");
								}
							} else {
								typeList.add("0");
								typeList.add("0");
								typeList.add("0");
								typeList.add("0");
							}
							String classId = row.getString("CLASS_ID");
							classList.add(typeList);
							classMap.put(classId, classList);
							//判断是否是最后一个，最后一个没法获取下一个进行比较
							if (rsClass.size()-1 != i) {
								//判断型号所属的类别是否和下一个型号的所属类型是否相同，
								//如果相同存放到同一个列表中若果不相同则从新定义一个list
								row = rsClass.get(i + 1);
								if (!classId.equals(row.getString("CLASS_ID"))) {
									classList = new ArrayList<List>();
								}
							}
						}
					}
				} else {

					Vector orgs = dbSysOrg.findAllWhere("PARENT_ID = "+ Transaction.formatString(enSysOrg.getOrgId()));
					
					// 各种型号库存
					if (orgs != null && orgs.size() > 0) {
						
						//遍历所有的型号，根据型号统计各个公司的相应型号的库存
						for (int j = 0; j < rsClass.size(); j++) {
							List<String> typeList = new ArrayList<String>();
							row = rsClass.get(j);
							if (row != null) {
								String typeId = row.getString("TYPE_ID");
								typeList.add(row.getString("CLASS_NAME"));
								typeList.add(row.getString("TYPE_NAME"));
								
								// 统计每个型号的总库存
								String sqlAmountAll = "select ifnull(sum(online_amount),0) online , ifnull(sum(stock_amount),0) amount , "
									+ "ifnull(sum(incons_amount),0) incons ,"
									+ "ifnull(sum(BAD_AMOUNT),0) bad"
									+ " from resource_org_amount r ,sys_org s"
									+ " where r.org_id = s.org_id"
									+ " and r.resource_type_id = '" + typeId
									+ "' and (r.org_id = '" + orgId 
									+ "' or s.parent_id ='" + orgId
									+ "')";
								
								rsAmount = transaction.doQuery(null,sqlAmountAll);
								
								//将总库存存放到列表中如果查找不到填写0
								if(rsAmount != null){
									rowAmount = rsAmount.get(0);
									if(rowAmount != null){
										typeList.add(orgId + "," + typeId + ",1," + rowAmount.getString("online"));
										typeList.add(orgId + "," + typeId + ",2," + rowAmount.getString("amount"));
										typeList.add(orgId + "," + typeId + ",3," + rowAmount.getString("incons"));
										typeList.add(orgId + "," + typeId + ",4," + rowAmount.getString("bad"));
									}else{
										typeList.add("0");
										typeList.add("0");
										typeList.add("0");
										typeList.add("0");
									}
								}else{
									typeList.add("0");
									typeList.add("0");
									typeList.add("0");
									typeList.add("0");
								}
								
								long onLine = 0;
								long amount = 0;
								long incons = 0;
								long bad = 0;
								// 遍历各个分公司，统计各个分公司库存
								if(orgs.size() == 1 && j == 0){
									org.add("");
								}
								for (int i = 0; i < orgs.size(); i++) {
									enSysOrg = (EnSysOrg) orgs.get(i);
									//在首次遍历类型时，把每个公司的名字存放到list列表中
									if (j == 0) {
										org.add(enSysOrg.getOrgName());
									}
									//拼写各给分公司的库存统计sql
									String sqlAmount = "select ifnull(sum(online_amount),0) online , ifnull(sum(stock_amount),0) amount ,  " 
											+ "ifnull(sum(incons_amount),0) incons ,"
											+ "ifnull(sum(BAD_AMOUNT),0) bad"
											+ " from resource_org_amount r , sys_org s"
											+ " where r.org_id = s.org_id"
											+ " and r.resource_type_id = '" + typeId
											+ "' and (r.org_id = '" + enSysOrg.getOrgId() 
											+ "' or s.parent_id ='" + enSysOrg.getOrgId()
											+ "')";
									rsAmount = transaction.doQuery(null,sqlAmount);

									//将各个分公司的库存分别存放到列表中，如果查找不到填写0
									if (rsAmount != null) {
										rowAmount = rsAmount.get(0);
										if (rowAmount != null) {
											onLine = onLine + rowAmount.getLong("online");
											amount = amount + rowAmount.getLong("amount");
											incons = incons + rowAmount.getLong("incons");
											bad = bad + rowAmount.getLong("bad");
											typeList.add(enSysOrg.getOrgId() + "," + typeId + ",1," + rowAmount.getString("online"));
											typeList.add(enSysOrg.getOrgId() + "," + typeId + ",2," + rowAmount.getString("amount"));
											typeList.add(enSysOrg.getOrgId() + "," + typeId + ",3," + rowAmount.getString("incons"));
											typeList.add(enSysOrg.getOrgId() + "," + typeId + ",4," + rowAmount.getString("bad"));
										} else {
											typeList.add("0");
											typeList.add("0");
											typeList.add("0");
											typeList.add("0");
										}
									} else {
										typeList.add("0");
										typeList.add("0");
										typeList.add("0");
										typeList.add("0");
									}
								}
								typeList.set(2, orgId + "," + typeId + ",1," + Long.toString(onLine));
								typeList.set(3, orgId + "," + typeId + ",2," + Long.toString(amount));
								typeList.set(4, orgId + "," + typeId + ",3," + Long.toString(incons));
								typeList.set(5, orgId + "," + typeId + ",4," + Long.toString(bad));
								String classId = row.getString("CLASS_ID");
								classList.add(typeList);
								classMap.put(classId, classList);
								//判断是否是最后一个，最后一个没法获取下一个进行比较
								if (rsClass.size()-1 != j) {
									row = rsClass.get(j + 1);
									//判断型号所属的类别是否和下一个型号的所属类型是否相同，
									//如果相同存放到同一个列表中若果不相同则从新定义一个list
									if (!classId.equals(row
											.getString("CLASS_ID"))) {
										classList = new ArrayList<List>();
									}
								}
							}else{
								throw new ErrorException("AS0001", null);
							}
						}
					}
				}
				//不查找到的数据存放到requestXml对象中
				if (requestXml.getRowCount("AMOUNT_STAT_LIST") == 0) {
					requestXml.addRow("AMOUNT_STAT_LIST");
				}
				requestXml.setItemValue("AMOUNT_STAT_LIST", 1, "AMOUNT_STAT",
						classMap);
				requestXml.setItemValue("AMOUNT_STAT_LIST", 1, "AMOUNT_STAT_ORG",
						org);
				requestXml.setItemValue("AMOUNT_STAT_LIST", 1, "CLASS_FOR", classFor);
			}else{
				throw new ErrorException("AS0001", null);
			}
			
		}else{
			throw new ErrorException("AS0001", null);
		}
		
	}
}