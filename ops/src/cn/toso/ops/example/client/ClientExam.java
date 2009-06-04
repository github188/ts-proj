package cn.toso.ops.example.client;

import cn.toso.ops.client.api.OpsApi;
import cn.toso.ops.client.entity.ResponseData;


public class ClientExam {

	/**
	 * 只提交参数，不关心返回值的例程
	 */
	void exampleA() {

		// 1.实例化EapApi
	    OpsApi oa= new OpsApi();
	    ResponseData rd=new ResponseData();
		
		int exeRes;
		String userId;
		userId = "000000000000000000000001";// 24位用户号
		exeRes = oa.eapRetrieveOTP(userId, "", rd);//获取动态口令
		if (exeRes == 0) {
			// 执行成功
		    String otp = rd.getString("");
		    System.out.println("OTP:"+otp);
		} else {
			// 执行失败
		}
	}

	public static void main(String[] args) {
		ClientExam example = new ClientExam();
		
		example.exampleA();

		
	}
}
