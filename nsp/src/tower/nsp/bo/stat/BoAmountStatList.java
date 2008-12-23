package tower.nsp.bo.stat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;

import tower.common.util.DateFunc;
import tower.common.util.RepDate;
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
 * @author 黄云敬 2008-12-19 上午09:00:15
 */
public class BoAmountStatList implements RootBo {

	public void doBusiness(Transaction transaction, XMLWrap requestXml,
			XMLWrap sessionXml, XMLWrap applicationXml, Logger logger)
			throws ErrorException {
		// TODO Auto-generated method stub
		/***********************************************************************
		 * 声明变量
		 **********************************************************************/

		//机构
		DbSysOrg dbSysOrg;
		EnSysOrg enSysOrg;
		//资源类别
		Vector resClasses;
		DbResourceClass resourceClass;
		EnResourceClass enResourceClass;
		QueryResult rsClass;
		QueryResultRow rowClass;

		QueryResult rsAmount;
		QueryResultRow rowAmount;

		List<List> classList = new ArrayList<List>(); 				//存放每个类型下的所有型号的信息
		HashMap<String,List> classMap = new HashMap<String,List>();	//存放所有的类型
		List<String> classFor = new ArrayList<String>();//存放所有的类别

		// 获取参数：
		String orgId;

		List<String> org = new ArrayList<String>();					//存放所有的分公司的名字
		
		//获取当前日期
		Date d = new Date();
		String date = DateFunc.GenDate(d);
		//日期转换当月
		RepDate rd = new RepDate();
		rd.genTerm(date, RepDate.MONTH, 0);
		String bgnDate = rd.getBgnDate()+"000000";
		String endDate = rd.getEndDate()+"999999";
		//上个月
		rd.genTerm(date, RepDate.MONTH, -1);
		String bgnDateBefor = rd.getBgnDate()+"000000";
		String endDateBefor = rd.getEndDate()+"999999";
		
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
		//判断机构是否存在
		if(orgId != null && orgId.length() > 0){
			
			enSysOrg = dbSysOrg.findByKey(orgId);
			
			//判断机构是否查找到
			if(enSysOrg != null){
				
				//组装查询数据
				String sqlClass = "select * from resource_class, resource_type"
					+ " where resource_class.class_id = resource_type.resource_class_id"
					+ " order by resource_class.class_id asc, resource_type.type_id asc;";
				rsClass = transaction.doQuery(null, sqlClass);
				//判断是否添加了资源型号
				if (rsClass == null || rsClass.size() == 0) {
					throw new ErrorException("AS0001", null);
				}else{
					//统计资源类型目的是在页面中获取存储库存的键值
					resClasses = resourceClass.findAll();
					for(int i = 0 ; i < resClasses.size() ; i ++){
						enResourceClass = (EnResourceClass) resClasses.get(i);
						classFor.add(enResourceClass.getClassId());
					}
					
					//根据机构的类别进行统计1、总公司（网优中心）2、分公司
					if(enSysOrg.getParentId() != null && enSysOrg.getParentId().length() > 0){
						//分公司
						for(int i = 0 ; i < rsClass.size() ; i ++){
							//定义每个类别的所有类型
							List<String> typeList = new ArrayList<String>();
							rowClass = rsClass.get(i);
							if(rowClass != null){
								String typeId = rowClass.getString("TYPE_ID");
								typeList.add(rowClass.getString("CLASS_NAME"));
								typeList.add(rowClass.getString("TYPE_NAME"));
								
								String onlice="0";//本月在线数量
								String amount="0";//本月库存数量
								String newAmount="0";//本月新到数量
								String outAmount="0";//在线出库数量
								String onAmount="0";//上线数量
								
								//获取每个型号的本月在线数、库存数
								String currentAmountSql = "select (ifnull(sum(stock_amount),0) + ifnull(sum(bad_amount),0) + ifnull(sum(incons_amount),0)) amount ," +
									" ifnull(sum(online_amount),0) onlice from resource_org_amount r" +
									" ,sys_org s  where r.org_id = s.org_id and resource_type_id = '"
									+ typeId + "' and (s.org_id ='" +enSysOrg.getOrgId()
									+ "' or s.parent_id = '" + enSysOrg.getOrgId()+"')";
								rsAmount = transaction.doQuery(null,currentAmountSql);
								if(rsAmount != null){
									rowAmount = rsAmount.get(0);
									if(rowAmount != null){
										onlice = rowAmount.getString("onlice");
									    amount = rowAmount.getString("amount");
									}
								}
								//获取本月新到数
								String newAmountSql = "SELECT ifnull(sum(in_amount),0) allAmount FROM resource_buyin_list r,sys_org s" +
									" where r.org_id=s.org_id and in_out_flag='I' and in_oper_datetime >= '"+
									bgnDate +"' and in_oper_datetime <= '"+
									endDate + "' and (s.org_id = '" + enSysOrg.getOrgId()+
									"' or s.parent_id ='" + enSysOrg.getOrgId()+"') and resource_type_id = '" + typeId+"'";
								rsAmount = transaction.doQuery(null,newAmountSql);
								if(rsAmount != null){
									rowAmount = rsAmount.get(0);
									if(rowAmount != null){
										newAmount = rowAmount.getString("allAmount");
									}
								}
								//获取上个月的在线数量
								String outAmountSql="SELECT ifnull(sum(amount_prepare),0) outAmount FROM resource_prepare_list r " +
									"where OUT_RESOURCE_STATUS='1' and OUT_OPER_DATETIME >= '" +
									bgnDateBefor + "' and OUT_OPER_DATETIME <= '" +
									endDateBefor +"'and LIST_STATUS >= '3'" +
									" and OUT_ORG_ID ='"+enSysOrg.getOrgId()+"' and resource_type_id = '" + typeId+"'";
								rsAmount = transaction.doQuery(null,outAmountSql);
								if(rsAmount != null){
									rowAmount = rsAmount.get(0);
									if(rowAmount != null){
										outAmount = rowAmount.getString("outAmount");
									}
								}
								String onAmountSql="SELECT ifnull(sum(amount_prepare),0) outAmount FROM resource_prepare_list r " +
									"where OUT_OPER_DATETIME >= '" +
									bgnDateBefor + "' and OUT_OPER_DATETIME <= '"+
									endDateBefor +"'and LIST_STATUS = '6'" +
									" and OUT_ORG_ID = '" + enSysOrg.getOrgId()+"' and resource_type_id = '" + typeId +"'";
								rsAmount = transaction.doQuery(null,onAmountSql);
								if(rsAmount != null){
									rowAmount = rsAmount.get(0);
									if(rowAmount != null){
										onAmount = rowAmount.getString("outAmount");
									}
								}
								long beforAmount = Long.parseLong(onlice) - Long.parseLong(onAmount) + Long.parseLong(outAmount);
								
								
								//添加上个月的在线数量
								typeList.add(String.valueOf(beforAmount));
								//添加本月在线数量
								typeList.add(onlice);
								//添加本月新到数量
								typeList.add(newAmount);
								//添加库存数量
								typeList.add(enSysOrg.getOrgId()+","+typeId + ","+amount);
								
								String classId = rowClass.getString("CLASS_ID");
								classList.add(typeList);
								classMap.put(classId, classList);
								//判断是否是最后一个，最后一个没法获取下一个进行比较
								if (rsClass.size()-1 != i) {
									//判断型号所属的类别是否和下一个型号的所属类型是否相同，
									//如果相同存放到同一个列表中若果不相同则从新定义一个list
									rowClass = rsClass.get(i + 1);
									if (!classId.equals(rowClass.getString("CLASS_ID"))) {
										classList = new ArrayList<List>();
									}
								}
							}
						}
					}else{
						//总库存
						
						//获取所有的分公司
						Vector orgs = dbSysOrg.findAllWhere("PARENT_ID = "+ Transaction.formatString(enSysOrg.getOrgId()));
						for(int i = 0 ; i < rsClass.size() ; i ++){
							//定义每个类别的所有类型
							List<String> typeList = new ArrayList<String>();
							rowClass = rsClass.get(i);
							if(rowClass != null){
								String typeId = rowClass.getString("TYPE_ID");
								typeList.add(rowClass.getString("CLASS_NAME"));
								typeList.add(rowClass.getString("TYPE_NAME"));
								
								String onlice="0";//本月在线数量
								String amount="0";//本月库存数量
								String newAmount="0";//本月新到数量
								String outAmount="0";//在线出库数量
								String onAmount="0";//上线数量
								
								//获取每个类型的本月在线数量、库存数量
								String currentAmount = "select (ifnull(sum(stock_amount),0) + ifnull(sum(bad_amount),0) + ifnull(sum(incons_amount),0)) amount ," +
										" ifnull(sum(online_amount),0) onlice from resource_org_amount where resource_type_id = '"
										+ typeId + "' and resource_type_id = '" + typeId+"'";
								rsAmount = transaction.doQuery(null,currentAmount);
								if(rsAmount != null){
									rowAmount = rsAmount.get(0);
									if(rowAmount != null){
										onlice = rowAmount.getString("onlice");
									    amount = rowAmount.getString("amount");
									}
								}
								
								//获取每个类型的本月新到数量
								String newAmountSql = "SELECT ifnull(sum(in_amount),0) allAmount FROM resource_buyin_list r" +
										" where in_out_flag='I' and in_oper_datetime >= '"+
										bgnDate +"' and in_oper_datetime <= '"+
										endDate + "' and resource_type_id = '" + typeId+"'";
								rsAmount = transaction.doQuery(null,newAmountSql);
								if(rsAmount != null){
									rowAmount = rsAmount.get(0);
									if(rowAmount != null){
										newAmount = rowAmount.getString("allAmount");
									}
								}
								//获取上个月的在线数量
								String outAmountSql="SELECT ifnull(sum(amount_prepare),0) outAmount FROM resource_prepare_list r " +
										"where OUT_RESOURCE_STATUS='1' and OUT_OPER_DATETIME >= '" +
										bgnDateBefor + "' and OUT_OPER_DATETIME <= '"+
										endDateBefor +"'and LIST_STATUS >= '3' and resource_type_id = '" + typeId+"'";
								rsAmount = transaction.doQuery(null,outAmountSql);
								if(rsAmount != null){
									rowAmount = rsAmount.get(0);
									if(rowAmount != null){
										outAmount = rowAmount.getString("outAmount");
									}
								}
								String onAmountSql="SELECT ifnull(sum(amount_prepare),0) onAmount FROM resource_prepare_list r " +
								"where OUT_OPER_DATETIME >= '" +
								bgnDateBefor + "' and OUT_OPER_DATETIME <= '"+
								endDateBefor +"'and LIST_STATUS = '6' and resource_type_id = '" + typeId+"'";
								rsAmount = transaction.doQuery(null,onAmountSql);
								if(rsAmount != null){
									rowAmount = rsAmount.get(0);
									if(rowAmount != null){
										onAmount = rowAmount.getString("onAmount");
									}
								}
								long beforAmount = Long.parseLong(onlice)+Long.parseLong(outAmount)-Long.parseLong(onAmount);
								//添加上个月的在线数量
								typeList.add(String.valueOf(beforAmount));
								//添加本月在线数量
								typeList.add(onlice);
								//添加本月新到数量
								typeList.add(newAmount);
								//添加库存数量
								typeList.add(amount);
								
								//获取所有分公司的库存数量
								long allAmount = 0;
								for(int j = 0 ; j < orgs.size() ; j++){
									enSysOrg = (EnSysOrg) orgs.get(j);
									if(i == 0){
										org.add(enSysOrg.getOrgName());
									}
									String subAmount = "0";
									String subAmountSql = "SELECT (ifnull(sum(stock_amount),0) + ifnull(sum(bad_amount),0) + ifnull(sum(incons_amount),0)) subAmount" +
											"  FROM resource_org_amount r,sys_org s where r.org_id = s.org_id and "+
											"(s.org_id = '" + enSysOrg.getOrgId()+"' or  s.parent_id ='"+
											enSysOrg.getOrgId()+"') and resource_type_id = '" + typeId+"'";
									rsAmount = transaction.doQuery(null,subAmountSql);
									if(rsAmount != null){
										rowAmount = rsAmount.get(0);
										if(rowAmount != null){
											subAmount = rowAmount.getString("subAmount");
											allAmount = allAmount + Long.parseLong(subAmount);
										}
									}
									typeList.add(enSysOrg.getOrgId()+","+typeId +","+subAmount);
								}
								typeList.set(5, enSysOrg.getParentId()+","+typeId+","+allAmount);
								//组装类别数据的hashMap表
								String classId = rowClass.getString("CLASS_ID");
								classList.add(typeList);
								classMap.put(classId, classList);
								//判断是否是最后一个，最后一个没法获取下一个进行比较
								if (rsClass.size()-1 != i) {
									rowClass = rsClass.get(i + 1);
									//判断型号所属的类别是否和下一个型号的所属类型是否相同，
									//如果相同存放到同一个列表中若果不相同则从新定义一个list
									if (!classId.equals(rowClass
											.getString("CLASS_ID"))) {
										classList = new ArrayList<List>();
									}
								}
							}
						}
					}
				}
				
				//将组装好的数据保存到requestXml对象中
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
