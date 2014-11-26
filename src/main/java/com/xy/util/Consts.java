package com.xy.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;


/**
 * @Description: 系统基本常量 常量管理类
 *  		     系统常量定义
 * @author       戴泳材
 * @date:2014-3-12 上午11:17:01
 * @version: V1.0 
 */
public class Consts {
	
	//内控评价部分
	public static final String BusinessPro="BusinessPro";//字典表的BusinessPro。业务属性	
	public static final String yyyyMMdd="yyyyMMdd";//日期格式化类型
	public static final String showDate="yyyy年MM月dd日";//日期格式化类型
	
	//数据库配置部分
	public static String Driver_Name="";//数据库驱动名；
	public static String URL="";//数据库URL；
	public static String UserName="";//数据库登陆名；
	public static String Password="";//数据库密码；
	public static String Driver_Register="";//数据库驱动是否需要注册？
	public static String EX_URL=""; //数据库URL辅助信息
	
	//OCR数据库配置部分
	public static String DB_Driver_Name_OCR="";//数据库驱动名；
	public static String DB_URL_OCR="";//数据库URL；
	public static String DB_UserName_OCR="";//数据库登陆名；
	public static String DB_Password_OCR="";//数据库密码；
	public static String DB_Driver_Register_OCR="";//数据库驱动是否需要注册？
	
	//ORC文件服务
	public static String File_ServerIp="";//文件服务器
	public static Integer File_Port=0;//端口
	public static String File_ImgRoot="";//图像路径	
	
	//AUDIT文件服务
	public static String File_ServerIp_audit="";//文件服务器
	public static Integer File_Port_audit=0;//端口
	public static String File_ImgRoot_audit="";//图像路径	
	public static String Sql_Server_Flag="";//文件服务类型	0：表示Linux，1：表示Window 版本
	
	public static final String SiteNo="SiteNo";//字典表中的fieldname。网点
	public static final String OperatorNo="OperatorNo";//字典表中的fieldname。柜员
	public static final String AUDIT_TYPE="AuditType";//字典表中的fieldname。审计大类型,项目类型
	public static final String RecordType="RecordType";//字典表中的fieldname。审计大类型
	public static final String PrivType="PrivType";//字典表中的fieldname。用户文档权限表AdUserprivtb表中的PrivType权限类型
	public static final String StepStatus="StepStatus";//字典表中的StepStatus。审计步骤状态,
	public static final String ArchiveType="ArchiveType";//字典表中的ArchiveType。档案类型,
	public static final String ArchiveStatus="ArchiveStatus";//字典表中的ArchiveStatus。档案状态
	public static final String AuditProjectRole="AuditProjectRole";//审计组员角色
	public static final String AuditStage="AuditStage";  //字典表中的AuditStage,审计阶段
	public static final String AuditMemberStepContrl="0";  //审计成员的可操作步骤根据模板进行过滤 1-启用 0-关闭
	public static final String AUDIT_GRADE="AuditGrade";  //字典表中的AuditStage,项目级别
	public static final String AUDIT_CAUSE="AuditCause";  //字典表中的AuditCause,立项依据
	public static final String TypeArchiveType="TypeArchiveType";  //字典表中的AuditCause,立项依据
	public static final String MenSex="MenSex";  //字典表中的MenSex,性别
	public static final String UploadFileType="UploadFileType";  //字典表中的UploadFileType上传文件类型
	public static final String AUDIT_WAY = "AuditWay";// 审计方式 1现场 2非现场
	public static final String BUSS_UNIT = "BussUnit";//业务单元
	
	public static final String AuditManStatus="AuditManStatus";  //字典表中的AuditManStatus,审计人员状态
	public static final String LogType="LogType";  //字典表中的LogType,日志类型
	public static final String BusinessType="BusinessType";//字典表的businessType。业务表类型	
	public static final String Granularity="Granularity";//字典表的granularity。粒度
	public static final String CaseType="CaseType";  //字典表中的CaseType,审计案例类型
	public static final String BussType="BussType";  //字典表中的CaseType,案例业务类型
	public static final String COLUMNPROPERTY = "ColumnProperty"; // 结果表字段属性
	public static final String ACCOUNT_SUBJECT = "ACCOUNT_SUBJECT"; // 字典表会计科目  彭辉：2012-05-09
	public static final String PARAM_TYPE = "PARAM_TYPE"; // 字段表参数  彭辉：2012-05-09
	public static final String OUTER_INTERFACE="OUTER_INTERFACE";//外部接口字段
	public static final String TABLE_TYPE = "TABLE_TYPE"; // 数据表类型
	public static final String PersRate = "PersRate";//字典表的persRate。追踪频率
	
    //图标类型
	public static final String ChartTypeBar="ChartTypeBar";             //单柱状图
    public static final String ChartTypeGroupBar="ChartTypeGroupBar";   //多柱状图
    public static final String ChartTypePie="ChartTypePie";             //饼图
    public static final String ChartTypeLine="ChartTypeLine";           //折线图
    public static final String ChartTypeGroupLine="ChartTypeGroupLine"; //多折线图
    public static final String ChartTypeTimeSeries="ChartTypeTimeSeries";  //时序图
    //图标热点
    public static final String ChartHaveHot="ChartHaveHot";   //图标有热点
    public static final String ChartNoHot="ChartNoHot";       //图标没有热点
    //时序图时的时间
    public static final String ChartDay="ChartDay";     //日
    public static final String ChartMonth="ChartMonth"; //月
    public static final String ChartYear="ChartYear";   //年
	
    
	public static final String Position="Position";//字典表中的Position。岗位职务类型
	public static final String AUDIT_ORG_LEVEL="AuditOrgLevel";//字典表中的AuditOrgLevel。审机构级别
	public static final String AUDIT_ORG_TYPE="AuditOrgType";//字典表中的AuditOrgType。审机构级别
	public static final String ORG_LEVEL="OrgLevel";//字典表中的OrgLevel。被审机构级别
	public static final String ORG_TYPE="OrgType";//字典表中的OrgType。被审机构级别
	public static final String FileType="FileType";//字典表中的fieldname。材料类型
	public static final String AlertHandlePKSQL="select max(id) from AlertHandle";
	public static final String ProblemDetailFlag="ProblemDetailFlag";//问题库明细的处理等级
	
	public static final String ocrimgs="ocrimgs";//图象下载的到的所在目录
	public static final String all="-1";//下拉菜单中的“所有”value值 String类型；
	public static final Integer all_Integer=-1;//下拉菜单中的“所有”value值 Integer类型；
	public static final Integer FileServerId=1;//FileServerId表中查找文件服务器IP，端口的ID号。
	public static String path="";//图片下载存储路径,注：最后没有“\\”
	
	//一些固定表名,字段名
	public static final String Batchinfotb="batchinfotb";//历史批次信息表
	public static final String Temp_batch="temp_batch";//临时批次信息表
	public static final String batchid="batchid";//批次号
	public static final String occurdate="occurdate";//发生日期
	public static final String Dicinfo="Dicinfo";//数据字典表
	public static final String LargeFileName="largefilename";//历史批次信息表，临时批次信息表共有字段
	public static final String Machineid="machineid";//临时批次信息表中的字段
	public static final String ocrips="ocrips";//历史表前缀
	public static final String lengthofcolorimage="lengthofcolorimage";//ocrips+日期表中的字段
	public static final String offsetofcolorimage="offsetofcolorimage";//ocrips+日期表中的字段
	public static final String inccodeinbatch="inccodeinbatch";//批内码
	public static final String AD_NEWAUDITTB="AD_NEWAUDITTB";//AD_NEWAUDITTB表
	public static final String AD_OPERATORTB="AD_OPERATORTB";//AD_OPERATORTB表
	public static final String AD_AUDITFILETB="AD_AUDITFILETB";//AD_AUDITFILETB表
	public static final String AD_MODELBATCHRUNTB="AD_MODELBATCHRUNTB";//AD_Modelbatchruntb表
	public static final String UploadFileStatus="UploadFileStatus";  //字典表中的UploadFileStatus,上传文件状态
	
	public static final String MessageType="MessageType";  //字典表中的MessageType,
	public static final String ProblemType="ProblemType";//问题库类型,跟ProcedureType一样
	public static final String ProblemType_ServiceLine="ServiceLine";//问题库类型,业务条线类型
	public static final String WORD_PUNISH = "WORD_PUNISH";   // 问题词条-行政处罚级别 (1-警告 2-记过 3-记大过 4-留职查看 5-撤职 6-开除)
	
//	系统操作日志 (变更) 2012-07-11 叶金荣
//	0：表示退出 1:表示登入  存放于表：AD_SYS_LOGINOPERTB中
//  2：表示我的工作台 3：审计查询查证 4：表示风险预警 5：表示模型管理 8：知识库 9：问题库管理 10:基础管理平台 
//	存放于表：AD_SYS_OTHEROPERTB中
//	6：表示审计信息管理 7：表内控评价 存放于表：ad_sys_flowopertb中
	public static final int SYS_OPERATE_LOGOUT = 0; // 表示退出
	public static final int SYS_OPERATE_LOGIN = 1;  // 表示登陆
	public static final int SYS_OPERATE_MYWORK = 2; // 表示我的工作台
	public static final int SYS_OPERATE_SJCXCZ = 3; // 表示审计查询查证
	public static final int SYS_OPERATE_FXYJ = 4; // 表示风险预警
	public static final int SYS_OPERATE_MODEL = 5; // 表示模型管理
	public static final int SYS_OPERATE_SJXXGL = 6; // 表示审计信息管理
	public static final int SYS_OPERATE_ECIO = 7; // 表示内控评价
	public static final int SYS_OPERATE_ZSK = 8; // 表示知识库
	public static final int SYS_OPERATE_PROBLEM = 9; // 表示问题库管理
	public static final int SYS_OPERATE_JCGLPT = 10; // 表示基础管理平台
	
	public static final int SYS_OPERATE_XMJH = 12; // 项目计划
	public static final int SYS_OPERATE_XXJLLT = 13; // 信息交流 论坛
	public static final int SYS_OPERATE_RYDTWH = 14; // 审计项目管理 人员动态维护
	public static final int SYS_OPERATE_OFFSDOC = 15; // 非现场审计文档
	public static final int SYS_OPERATE_OTHER = 99; // 表示其他
	public static final int SYS_OPERATE_WDGL = 16; // 表示项目文档管理
	public static final int SYS_OPERATE_GZDG = 20; // 表示项目文档管理
	public static final int SYS_OPERATE_XCXXLR = 17; // 表示现场信息录入
	public static final int SYS_OPERATE_NKPJ = 18; // 表示内控评级
	public static final int SYS_OPERATE_ASS = 19; // 项目考核指标
	
	public static final int SYS_OPERATE_DCWJ = 11; // 调查问卷
	public static final int SYS_OPERATE_JGCZ = 23; // 监管查证
	public static final int SYS_OPERATE_JGGL = 21; //审计机构管理
	public static final int SYS_OPERATE_WKRD = 22; //工作底稿
	public static final int SYS_OPERATE_SJCY = 24; // 审计抽样
	//AdUserprivtb表中privtype的类型
	public static final String aup_privtype_1="1";//文档新建，上传，扫描，文档修改续写。
	public static final String aup_privtype_2="2";//下载，查看。
	public static final String aup_privtype_3="3";//删除。
	public static final String oper_username="username";//审计模板当前操作人的值
	public static final String oper_indexs="tmepletindexs";//审计模板索引号
	public static final String template_not_repeat="复核意见,复核人,复核日期";
	public static final String template_not_approval="审批意见,审批人,审批日期";
	public static final String templateType_Implementation="040"; //审计模板--实施方案 DICINFO中MedelDocType
	public static final Long MODELSTAGE_READY=30l; //审计模板-审计准备-- DICINFO中ModelStage
	public static final Long MODELSTAGE_IMPLEMENT=40l; //审计模板-审计实施-- DICINFO中ModelStage
	public static final Long MODELSTAGE_PROJECTEND=50l; //审计模板-审计实施-- DICINFO中ModelStage
	//界面按钮控制权限
	public static final String powerType_look = "powerType_look";
	
	/**项目成员角色**/
	public static final String AUDIT_WORKROLE="AuditWorkRole";
	//组长
	public static final String AUDITWORKROLE_0001="0001";
	//副组长（备用）
	public static final String AUDITWORKROLE_0002="0002";
	//主审
	public static final String AUDITWORKROLE_0003="0003";
	//副主审
	public static final String AUDITWORKROLE_0004="0004";
	//小组长
	public static final String AUDITWORKROLE_0005="0005";
	//成员
	public static final String AUDITWORKROLE_0006="0006";
	//走访（监管员）
	public static final String AUDITWORKROLE_0007="0007";
	
	//审计项目人员类型（old）
	public static final String MemberType = "MemberType";//审计项目人员类型
	
	
	/***************************************************************************************
	 * 审计流程使用
	 ***************************************************************************************/
	//审计模板管理
	public static final String ModelStage="ModelStage";  //字典表中的ModelStage,审计模板所属阶段
	public static final String MedelDocType="MedelDocType";  //字典表中的MedelDocType,模板文档类别
	public static final String ModelFieldType="ModelFieldType";  //字典表中的ModelFieldType,模板字段属性
	public static final String ModelSideType="ModelSideType";  //字典表中的ModelSideType,审计事项属性	
	public static final String SCRIPT_ELEMENT_CODE = "ScriptTemplate";//字典表中的ScriptTemplate,要素模版
	public static final String TemplateLableType="TemplateLableType";  //字典表中的TemplateLableType, 取值方式为系统取值时，取值内容类别 20120618
	public static final String AuditBussType = "AuditBussType"; //字典表中的fieldname,词条类型
	
	//输出到Excel时，每个Excel允许的记录数。
	public static Integer excel_size=0;
	//输出到TXT时，每个TXT允许的记录数。
	public static Integer txt_size=0;
	//密码有效期,单位:天
	public static Integer Password_valid=-1;
	//密码到期提示天数
	public static Integer Password_Due_NoticeDay=0;
	//excel下载授权 1:表示需要下载授权，0：表示不需要授权
	public static  String Excel_Authorize="1";
	//excel下载输入密码框 1:表示需要显示，0：表示不需要显示
	public static  String Excel_ShowPass="1";
	
	//模板的银行名前缀
	public static String template_prefix_1="";
	
	public static String template_prefix_2="";
	
	/** 机构号长度 */
	public static Integer ORGTB_ID_LEN = 0;
	/** 柜员号长度 */
	public static Integer OPERATOR_ID_LEN = 0;
	
	public static String  DBTYPE="0";//0:db2 1:oracle 3:IMFORMIX
	public static String  ORA_URL="";
	public static String  ORA_UserName="";
	public static String  ORA_Password="";
	
	//用户所管辖机构标致位
	public static String ManagerOrgFlag="";
	
	/** 系统路径 */
	public static String SYSPATH = "";
	
	/** ODS下载类型：0:表示当前目录中所有文件 1：表示单个文件下载 */
	public static String downFileType = "downFileType";
	
	/** sping 配置文件路径 */
	public static String APPLICATIONPATH = "";
	
	/**WEB应用路径下,临时文件夹路径,该路径下不做文件存储,仅作为临时存放文件**/
	public static String WEBTEMPFILEPATH = "";
	
	public static final String PlanType="PlanType";
	
	public static String MainBankNo="";
	public static final String PlanYear="PlanYear";    //计划年度 2008年度~2020年度
	
	
	// 接口类型
	public static final String interfaceType = "INTERFACE_TYPE"; 
	
	
	public static String USER_TYPE="USERLEVEL";
	
	//服务器 CPU数量
	public static int CPU_NUM = 0;
	
	/*****所属流程类型*****/
	public static String probdealflow = "probdealflow";	//现场审计问题处理流程
	public static String auditcommonflow = "auditcommonflow";	//文档_通用审批流程
	public static String noticeflow = "noticeflow";	//文档_审计通知书审批流程
	public static String evidenceflow = "evidenceflow";	//文档_审计取证单审批流程
	public static String problemBaseFlow = "problemBaseFlow";	//问题库处理流程
	public static String worktempflow = "worktempflow";	//文档_工作底稿审批流程
	public static String clewflow = "clewflow";	//线索处理流程
	public static String planprojectflow = "planprojectflow";	//计划项目审批流程
	
	
	public static String audit_evidence_id = "35";//审计取证底稿模板id
	
	public static boolean IS_USE_SWITCHSYSBAR = true; //是否启用 隐藏左边栏方法
	
	public static String ELEDATA_FILE_DELIMITER = "ELEDATA_FILE_DELIMITER"; //参数表-参数名  元数据文件分隔符
	
	//不在项目中心显示的底稿，比如工作底稿等。  格式 "底稿模板编号1,底稿模板编号2,底稿模板编号"
	public static String NO_SHOW_IN_CENTER = "7";
	
	//是否 递归查询 树型数据
	public final static boolean IS_RECURSION_QUERY = true;

	
	/**
	 * 现场审计 平台常量
	 */
	public static final boolean IS_AUDITHEADDELETEALL = true;//审计主评（包括组长，主查）是否有权限删除别人底稿 true:可以   false：不可以
	public static final boolean IS_AUDITPROJECT_ISDELETE = true;//项目项目已启动是否可以删除 true:可以 false：不可以
	public static final boolean IS_AUDITPROJECT_PROBLEMAFFIRM = false;//审计项目 问题整改是否需要 确认 是true 否false
	public static final boolean IS_AUDITPROJECT_OVERALTER = true;//审计项目主评人是否底稿档案完成后修改权限 是：true 否：false
	public static final boolean IS_EXECUTIONDETAIL = false;//审计实施方案审计要点显示明细 是否要显示 是:true 否：false
	public static final boolean IS_SHOW_IMPORTPROBLEM = false;// 审计项目实施 项目监控 项目问题情况 是否显示 问题导入问题库情况 2012-07-13 叶金荣
	public static final String UNSHOW_TEMPLATEID = "7,49,51"; // 审计模板配置不需要显示出来的模板id(工作底稿，整改通知书，事实确认书)
	public static final String TS_TYPE = "TsType"; // 现场审计-抽样任务表AD_FLOW_TASKS_SPGTB.ts_id（ 字典表汉化）
	
	//工作计划状态 0未开始 1进行中 2已结束
	final public static String WPSTATUS_0 = "0";//0未开始
	final public static String WPSTATUS_1 = "1";//1进行中
	final public static String WPSTATUS_2 = "2";//2已结束
	
	//审计项目状态
	//新状态: 0暂存 1项目立项 2方案审理 3审计实施 4报告撰写5报告审理 6征求意见 7报告二次审理 8报告二次审理完成 9正式发文 97项目结项 98首次追踪 99首次追踪完成
	public static final String ProgressFlag="ProgressFlag";//字典表中的Consts.ProgressFlag。审计项目状态,
	final public static int PROGRESSFLAG_ZC = 0;//0:暂存
	final public static int PROGRESSFLAG_XMLX = 1;//项目立项
	final public static int PROGRESSFLAG_FASL = 2;//方案审理
	final public static int PROGRESSFLAG_SJSS = 3;//审计实施
	final public static int PROGRESSFLAG_BGZX = 4;//报告撰写
	final public static int PROGRESSFLAG_BGSL = 5;//报告审理
	final public static int PROGRESSFLAG_ZQYJ = 6;//征求意见
	final public static int PROGRESSFLAG_BGECSL = 7;//报告二次审理
	final public static int PROGRESSFLAG_BGECWC = 8;//报告二次审理完成
	final public static int PROGRESSFLAG_ZSFW = 9;//正式发文
	final public static int PROGRESSFLAG_XMJX = 97;//项目结项
	final public static int PROGRESSFLAG_SCZZ = 98;//首次追踪
	final public static int PROGRESSFLAG_SCWC = 99;//首次追踪完成
	
	final public static String TREENAME_STATUS = "项目状态";
	
	//项目人员状态
	final public static String MemberStatus_0 = "0";//初选中
	final public static String MemberStatus_1 = "1";//复选中
	final public static String MemberStatus_2 = "2";//复选完成
	
//	//人员角色
//	public static String ZBFZR = "PartManager";//总部负责人
//	public static String ZBSLRYFZR = "SJXMSLFZR";//总部审理人员负责人
//	public static String ZBSLRY = "SJXMSLRY";//总部审理人员
//	public static String FBFZR = "FBFZR";//分部负责人
//	public static String FBSLRYFZR = "FBSJXMSLFZR";//分部审理人员负责人
//	public static String FBSLRY = "FBSJXMSLRY";//分部审理人员
//	public static String SUPERADM = "SuperAdm";//超级管理员
//	public static String ADMIN = "SysAdm";//系统管理员
	
	
//	//项目文档加密主体
//	final public static String SJXM_XMWD = "1";//1:文档
//	final public static String SJXM_WDLX = "2";//2:文档类型
//	final public static String SJXM_ALLDG = "3";//3:底稿（全部加密信息表）
//	final public static String SJXM_XM = "4";//4:项目
//	final public static String SJXM_DG = "2";//2:底稿（加密信息表）
//	
//	//项目文档附件类型
//	final public static String WDLX_FASSG = "0001";//审计方案送审稿
//	final public static String WDLX_FASSGFJ = "0002";//审计方案送审稿附件
//	final public static String WDLX_FAXDG = "0003";//审计方案修订稿
//	final public static String WDLX_FAXDGFJ = "0004";//审计方案修订稿附件
//	final public static String WDLX_FASLYJ = "0005";//审计方案审理意见附件
//	
//	final public static String WDLX_BGSSG = "0006";//审计报告送审稿
//	final public static String WDLX_BGSSGFJ = "0007";//审计报告送审稿附件
//	final public static String WDLX_BGXDG = "0008";//审计报告修订稿
//	final public static String WDLX_BGXDGFJ = "0009";//审计报告修订稿附件
//	final public static String WDLX_BGECSSG = "0010";//审计报告二次送审稿
//	final public static String WDLX_BGECSSGFJ = "0011";//审计报告二次送审稿附件
//	final public static String WDLX_BGECXDG = "0012";//审计报告二次修订稿
//	final public static String WDLX_BGECXDGFJ = "0013";//审计报告二次修订稿附件
//	final public static String WDLX_BGSLYJFJ = "0014";//审计报告审理意见附件
//	
//	//文档状态
//	final public static String WDZT_STATUS_1 = "1";//1-暂存  
//	final public static String WDZT_STATUS_2 = "2";//2-编写完成
//	final public static String WDZT_STATUS_3 = "3";//3-归档
	
	
	//项目类型，审计方式 特殊处理的类型和方式 不需要走首次追踪
	final public static String AUDITWAY_FXC = "2";//非现场项目
	final public static String AUDITTYPE_ZF = "0010";//项目类型 走访
	
	final public static String AUDIT_GROUP_NAME = "AuditGroupName";//现场业务小组名称fieldname
	
	/**
	 * 审计目标 
	 * 字典表[AD_DICINFOTB] FIELDNAME = 'AuditTarget';
	 */
	public static String AuditTarget = "AuditTarget";
	public static String AUDITTARGET_0010 = "0010";//[真实性]
	public static String AUDITTARGET_0011 = "0011";//[确切性]
	public static String AUDITTARGET_0012 = "0012";//[完整性]
	public static String AUDITTARGET_0013 = "0013";//[所有性]
	public static String AUDITTARGET_0014 = "0014";//[估价性]
	public static String AUDITTARGET_0015 = "0015";//[分类性]
	public static String AUDITTARGET_0016 = "0016";//[期限性]
	public static String AUDITTARGET_0017 = "0017";//[相符性]
	public static String AUDITTARGET_0018 = "0018";//[揭示性]
	public static String AUDITTARGET_0020 = "0020";//[遵循性]
	public static String AUDITTARGET_0021 = "0021";//[合法性]
	public static String AUDITTARGET_0022 = "0022";//[合规性]
	public static String AUDITTARGET_0023 = "0023";//[合理性]
	public static String AUDITTARGET_0030 = "0030";//[效益性]
	public static String AUDITTARGET_0031 = "0031";//[适当性]
	public static String AUDITTARGET_0032 = "0032";//[经济性]
	public static String AUDITTARGET_0033 = "0033";//[效率性]
	public static String AUDITTARGET_0034 = "0034";//[效果性]
	public static String AUDITTARGET_0035 = "0035";//[环境性]
	public static String AUDITTARGET_0099 = "0099";//[其他]
	/**
	 * 工作底稿的状态标志位
	 * 表[AD_FLOW_WORKRDTB] 字段[WK_STATUS]
	 * 含义(0起草中，1复核中，2审批中，3审批通过，4退回修改,5作废)
	 */
//	1	WkrdStatus	0	起草中			
//	2	WkrdStatus	1	提交复核			
//	3	WkrdStatus	2	提交审批			
//	4	WkrdStatus	3	审批通过			
//	5	WkrdStatus	4	复核退回			
//	6	WkrdStatus	5	作废			
//	7	WkrdStatus	6	审批退回			
//	8	WkrdStatus	7	审批通过后退回
	public static String WK_STATUS_0 = "0";//[起草中] 起草中
	public static String WK_STATUS_1 = "1";//[复核中] 提交复核
	public static String WK_STATUS_2 = "2";//[审批中] 提交审批
	public static String WK_STATUS_3 = "3";//[审批通过] 审批通过
	public static String WK_STATUS_4 = "4";//[退回修改] 复核退回
	public static String WK_STATUS_5 = "5";//[作废]  作废	
	public static String WK_STATUS_6 = "6";// 审批退回	
	public static String WK_STATUS_7 = "7";// 审批通过后退回
	
	/**
	 * 工作底稿的类型标志位/台账类型
	 * 表[AD_FLOW_WORKRDTB] 字段[WK_TYPE]
	 * 含义(0通用，1对公，2零售,3查访记录)(二期修改：增加底稿类型 4内控工作底稿)
	 */
	public static String WK_TYPE_0 = "0";//[通用]
	public static String WK_TYPE_1 = "1";//[对公]
	public static String WK_TYPE_2 = "2";//[零售]
	public static String WK_TYPE_3 = "3";//[查访记录]
	
	/**
	 * W：工作日 H节假日,导出excel信息(是否节假日)标注W:否0,H:是1
	 */
	public static String IS_HOLIDAY = "H";
	public static String IS_WORKDAY = "W";
	
	/*****************问责项目常量 开始*********************/
	public static final String AB_PROJ_STAT = "AbProjStat"; // 问责项目状态,字典表定义
	//11 提起 12 立项 13调查 14审议 15告知 16决定与执行 17复议 18结项 00 已关闭
	public static final String AB_PROJ_STAT_11 = "11";
	public static final String AB_PROJ_STAT_12 = "12";
	public static final String AB_PROJ_STAT_13 = "13";
	public static final String AB_PROJ_STAT_14 = "14";
	public static final String AB_PROJ_STAT_15 = "15";
	public static final String AB_PROJ_STAT_16 = "16";
	public static final String AB_PROJ_STAT_17 = "17";
	public static final String AB_PROJ_STAT_18 = "18";
	public static final String AB_PROJ_STAT_19 = "19";
	//问责项目来源,字典表定义
	public static final String PROJSRC = "ProjSrc";
	//问责核销每个阶段的处理状态 0 暂存 1 保存并下一步
	public static final String PROCFLAG = "ProcFlag";
	/*****************问责项目常量 结束*********************/
	
	/*****************核销项目常量 开始*********************/
	public static final String REV_PROJ_STAT = "RevProjStat"; // 核销项目状态,字典表定义
	//21 审理 22 审核 23审议 24结项 25关闭
	public static final String REV_PROJ_STAT_21 = "21";
	public static final String REV_PROJ_STAT_22 = "22";
	public static final String REV_PROJ_STAT_23 = "23";
	public static final String REV_PROJ_STAT_24 = "24";
	public static final String REV_PROJ_STAT_25 = "25";
	//大额核销项目类型
	public static final String RevType = "RevType";
	//币种
	public static final String MoneyType = "MoneyType";
	//阶段意见状态
	public static final String RevStepStatus = "RevStepStatus";
	//风险分类 ：正常1、正常2、正常3、关注1、关注2、关注3、次级、可疑、损失，共9类。
	public static final String RiskType = "RiskType";
	//业务环节
	public static final String BussLinks = "BussLinks";
	/*****************问责项目常量 结束*********************/
	
	/*****************非现场文档 开始*********************/
	public static final String ChkOrgOwn = "ChkOrgOwn";////检查机构隶属 标准字典：人民银行,银监局,审计机关,外汇管理局,国家发改委,财政专员办,国税局,地税局,公安局,统计局,物价局,其他
	
	public static final String ChkWay = "ChkWay";//检查方式 01 现场检查； 02 非现场检查
	/*****************非现场文档 结束*********************/
	/**
	 * 问题库 平台常量
	 */
	public static final String PRE_XCWT = "XC";//问题编号--现场审计问题前缀
	public static final String PRE_FXCWT = "FX";//问题编号--非现场问题前缀
	public static final String PRE_WBWT = "WB";//问题编号--外部问题前缀
	public static final String PRE_QTWT = "QT";//问题编号--其他问题前缀
	public static final String PRE_XQZG = "XQZG";//整改编号--限期整改前缀
	public static final String RISK_WORD_TYPE = "10000000,10000002,10000003"; //重点关注，风险词条类型，词条id

	
	/*********** -----------------工作流平台常量 开始-------------------------*/
	public static String  FlowBussType= "FlowBussType"; //字典表中的fieldname。工作流业务关联表ad_wf_infotb表中的BussType业务类型，存放业务表名称
	
	/*********** -----------------工作流平台常量 结束-------------------------*/
	
	/*********** -----------------问题库平台常量 开始-------------------------*/
	//字典表中的fieldname。审计问题库_审计问题临时表AD_PR_TEMP_PROBLEMSTB表中的PRO_BUSS_TYPE业务类型
	public static String  ProBussType= "ServiceLine";
	//字典表中的fieldname。审计问题库_审计问题临时表AD_PR_TEMP_PROBLEMSTB表中的pro_deal_state问题处理状态   0：未确认 1：确认中  2：已确认  4：已入库，5：废止
	public static String  ProDealState = "ProDealState";
	//问题库 问题来源 1-内部审计 2-内部检查 3- 外部检查 4-日常监管 5-拜访外部 6-非现场监管
	public final static String  PROB_SRC = "ProbSrc";
	public final static String  PROBSRC_NBSJ = "1";//1-内部审计
	public final static String  PROBSRC_NBJC = "2";//2-内部检查(行内检查)
	public final static String  PROBSRC_WBJC = "3";//3-外部检查
	public final static String  PROBSRC_RCZF = "4";//4-日常监管
	public final static String  PROBSRC_FXCJG = "5";//5-拜访外部
	public final static String  PROBSRC_6 = "6";//5-非现场监管
	
	//风险等级 EntrySettingYuJing
	//字典表中的fieldname。审计问题_问题整改信息表AD_PR_RECTIFYTB表中的REC_STATE整改状态 (0 - 未整改  1 - 整改中  2 - 整改完成 3- 部分整改)
	public static String  RecState = "RecState";
	//字典表中的fieldname。审计问题_问题整改信息表AD_PR_RECTIFY_DETTB表中的REC_ACTION整改状态 0: 未整改 1：整改中 2：已整改 3：无法整改 4：延期整改 5：无需整改
	public static String  RecAction = "RecAction";
	//字典表中的fieldname。审计问题_问题整改信息表AD_PR_RECTIFYTB整改方式RecType
	public static String  RecType = "RecType";
	
	public static String RpStatus = "RpStatus";  //审计问题库_处罚表AdPrPunishtb 状态 1-未提交 2-审查中 9-已归档
	
	/**
	 * 临时问题库是否是问题汉化
	 */
	public static Map<Integer, String> IS_PROB_MAP = new HashMap<Integer, String>();
	static {
		IS_PROB_MAP.put(0, "不是问题");
		IS_PROB_MAP.put(1, "是问题");
	}
	/**
	 * 问题库责任人类型
	 */
	public static Map<Integer, String> DUTY_MAP = new HashMap<Integer, String>();
	static {
		DUTY_MAP.put(1, "直接责任人");
		DUTY_MAP.put(2, "间接责任人");
	}
	
	/**
	 * 审计问题库_问题整改明细表是否逾期  0:未逾期 1：已逾期
	 */
	public static Map<Integer, String> IS_OUTTIME_MAP = new HashMap<Integer, String>();
	static {
		IS_OUTTIME_MAP.put(0, "未逾期");
		IS_OUTTIME_MAP.put(1, "已逾期");
	}
	
	/*********** -----------------问题库平台常量 结束-------------------------*/
	
	
	
	
	/**********-----------------------预警平台新增常量结束-----------------------*/
	/*********** -----------------角色权限常量 结束-------------------------*/
	//审计部门领导(审计部门经理)权限
	public static String  PRIV_SJBMLD = "SJBMLD";//标准版本为SJBMLD 厦门版本为bmjl
	/*********** -----------------角色权限常量 结束-------------------------*/
	
	/**********			附件表类型			*******/
	
	public static String PR_WTQR = "AUDIT_WTKGL_WTKGL_TPMG";//问题确认权限
	
	/**********					功能权限常量						***********/
	public static String GNQX_SJTZS="AUDIT_SJXXGL_SJXMGL_SJTZSQX";
	
	
	/*********					用户关联关系表					************/
	public static String REL_TYPE_1 = "1"; //用户与数据管辖机构关联表 
	public static String REL_TYPE_2 = "2";//用户角色关联表
	public static String REL_TYPE_3 = "3";//用户与业务条线关联表
	public static String REL_TYPE_4 = "4";//用户与线索问题机构
	
	/********					系统附件表					**********/
	public static String  SYS_FILE_PREFIX = "SYS_FILE_";//文件存放的文件夹名称 前缀
	public static Integer FILE_SRC_1=1;//审计项目
	public static Integer FILE_SRC_2=2;//审计计划
	public static Integer FILE_SRC_3=3;//审计文档
	public static Integer FILE_SRC_4=4;//消息附件
	public static Integer FILE_SRC_5=5;//工作流节点ID
	public static Integer FILE_SRC_6=6;//问题附件  :此时src_id保存问题ad_flow_auditresultstb.id 根据file_src及src_id确定是哪个问题的佐证
	public static Integer FILE_SRC_7=7;//日程附件
	public static Integer FILE_SRC_8=8;//内部共享平台附件
	
	public static Integer FILE_SRC_9=9; //查证附件
	public static Integer FILE_SRC_9_1=91;//查证文档
	public static Integer FILE_SRC_9_2=92;//查证核实文档
	
	
	public static Integer FILE_SRC_10=10;//问责附件
	public static Integer FILE_SRC_11=11;//新建工作计划附件
	public static Integer FILE_SRC_12=12;//大额核销附件
	
	public static Integer FILE_SRC_13 = 13; //非现场审计文档
	
	public static Integer FILE_SRC_14 = 14; //底稿附件
	
	public static Integer FILE_SRC_15 = 15; //外部问题录入附件
	
	public static Integer FILE_SRC_16 = 16; //项目文档管理文件
	public static Integer FILE_SRC_16_1 = 17; //项目文档附件
	
	public static Integer FILE_SRC_18 = 18; //内控评级文档
	
	public static Integer FILE_SRC_19 = 19; //底稿汇总单文档
	
	
	public static Integer FILE_SRC_20 = 20; //人员动态明细查询Excel
	
	
	/*******			综合信息表 AdGroupmessage			***********/
	public static String MESSAGETYPE_1="1";//个人
	public static String MESSAGETYPE_0="0";//公告
	
	/******************数据库用户信息***************/
	public static String SQL_USER="SJXT";//用户模型解锁的时候删除进程使用
	
	
	/********              内控评价参数             ****************/
	//归档项目是否可以删除 true:可以   false：不可以
	public static final boolean ecioProjectDeleteAll=true;
	//	内控评价 评价模板 类型 1：分值类型， 2：权重类型， "" 两者皆可 手动选择
	public static final String ecioTemplateType = "";
	
	public static final String EntrySettingYuJing = "EntrySettingYuJing"; //字典表预警级别
	//评级参数字典表定义
	public static final String ECIOPARAM = "EcioParam";
	//汇总评级字典表定义
	public static final String ECIOSUMLEVEL = "EcioSumLevel";
	//单项评级字典表定义
	public static final String ECIOUNILEVEL = "EcioUniLevel";
	
	//获取Spring上下文环境
	public static ApplicationContext APPLICATION;
	
	/******************基础管理平台 ***************/
	//用户信息
	public static final String POSITION = "UserPosition";//职务
	public static final String POSTITLE = "PosTitle";//职称
	public static final String EDULEVEL = "EduLevel";//学历
	public static final String USERPARTY = "UserParty";//政治面貌
	public static final String USERNATION = "UserNation";//民族
	public static final String EDUDEGREE = "EduDegree";//学位
	/******************基础管理平台 ***************/
	
	/****************** 待办事项 ***************/
	public static final String DAYSCHEME = "DAY_SCHEME";//现场项目（不含走访）的方案提交天数
	public static final String DAYREPORT = "DAY_REPORT";//现场项目（不含走访）的报告提交天数
	public static final String DAYZFSCHEME = "DAY_ZF_SCHEME";//走访项目的方案提交天数
	public static final String DAYZFREPORT = "DAY_ZF_REPORT";//走访项目的报告提交天数
	/****************** 待办事项 ***************/
	
	
}
