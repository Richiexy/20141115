//package com.xy.work;
//
//package com.sunyard.JunitTest;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
//public class GenerateData {
//	
//	@Autowired
//	public ApplicationContext app;
//	
//	@Autowired(required = false)
//	protected HqlOperate hqlOperate;
//	
//	@Autowired(required = false)
//	private IUtilService utilService;
//	
//	@Before
//	public void setUp() throws Exception {
//		SpringInstanceProvider sp = new SpringInstanceProvider(app);
//		InstanceFactory.setInstanceProvider(sp);
//	}
//	
//	/**
//	 * @Description: 批量生成数据
//	 * @author: 俞根海
//	 * @date: 2014-11-24 下午1:56:31
//	 */
//	@Test
//	public void generate(){
//		//分行
//		List<AdOrgtb> orgList = hqlOperate.getByHql(" from AdOrgtb where orgName like '%分行%' and orgLevel = '1' " , AdOrgtb.class);
//		Map<String,String> orgMap = new HashMap<String,String>();
//		for(AdOrgtb org : orgList){
//			orgMap.put(org.getId(), org.getOrgName());
//		}
//		System.out.println("-------" + orgMap.size());
//		//监管机构
//		List<AdSysCheckertb> sysCheckerList = hqlOperate.getByHql(" from AdSysCheckertb " , AdSysCheckertb.class);
//		Map<String,String> syscheckerMap = new HashMap<String,String>();
//		for(AdSysCheckertb syschecker : sysCheckerList){
//			syscheckerMap.put(syschecker.getId(), syschecker.getMainChecker());
//		}
//		//查询基本数据
//		List<AdEcioInfo> ecioInfoList = hqlOperate.getByHql(" from AdEcioInfo where apprYear = 2014 and apprQuarter = 2" , AdEcioInfo.class);
//		for(AdEcioInfo  ecioInfo : ecioInfoList){
//			//移除orgMap中数据
//			orgMap.remove( ecioInfo.getAuditOrg());
//		}
//		System.out.println("-------" + orgMap.size());
//		Integer infoId = 0;
//		if(ecioInfoList.size() > 0){
//			infoId = ecioInfoList.get(0).getInfoId();
//		}else{
//			System.out.println("没有该季度评级项目信息!");
//		}
//		for(String orgId : orgMap.keySet()){
//			//Ad_Ecio_Info
//			AdEcioInfo tmpEcioInfo = ecioInfoList.get(0);
//			tmpEcioInfo.setInfoId(null);
//			tmpEcioInfo.setAuditOrg(orgId);
//			tmpEcioInfo.setApprUser(syscheckerMap.get(orgId));
//			tmpEcioInfo.setCreateUser(syscheckerMap.get(orgId));
//			tmpEcioInfo.setLastModifier(syscheckerMap.get(orgId));
//			hqlOperate.save(tmpEcioInfo);
//			
//			//AD_ECIO_ITEM_RESULT
//			List<AdEcioItemResult> itemResultList = hqlOperate.getByHql(" from AdEcioItemResult where infoId = ? " ,
//					AdEcioItemResult.class , infoId);
//			System.out.println("----" + itemResultList.size());
//			for(AdEcioItemResult itemResult : itemResultList){
//				AdEcioItemResult itemResultTmp = itemResult; 
//				itemResultTmp.setIrId(null);
//				itemResultTmp.setInfoId(tmpEcioInfo.getInfoId());
//				itemResultTmp.setApprUser(tmpEcioInfo.getCreateUser());
//				itemResultTmp.setLastModifier(tmpEcioInfo.getLastModifier());
//				hqlOperate.save(itemResultTmp);
//			}
//			
//			//AD_ECIO_RESULT
//			List<AdEcioResult> resultList = hqlOperate.getByHql(" from AdEcioResult where infoId = ? " ,
//					AdEcioResult.class , infoId);
//			System.out.println("----" + resultList.size());
//			for(AdEcioResult result : resultList){
//				AdEcioResult resultTmp = result; 
//				resultTmp.setReId(null);
//				resultTmp.setInfoId(tmpEcioInfo.getInfoId());
//				resultTmp.setApprUser(tmpEcioInfo.getCreateUser());
//				resultTmp.setLastModifier(tmpEcioInfo.getLastModifier());
//				hqlOperate.save(resultTmp);
//			}
//			//AD_ECIO_PRO_WEIGHT
//			List<AdEcioProWeight> proWeightList = hqlOperate.getByHql(" from AdEcioProWeight where infoId = ? " ,
//					AdEcioProWeight.class , infoId);
//			System.out.println("----" + proWeightList.size());
//			for(AdEcioProWeight proWeight : proWeightList){
//				AdEcioProWeight proWeightTmp = proWeight; 
//				proWeightTmp.setPwId(null);
//				proWeightTmp.setInfoId(tmpEcioInfo.getInfoId());
//				hqlOperate.save(proWeightTmp);
//			}
//			
//		}
//		
//		
//	}
//}