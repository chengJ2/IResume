package resume.me.com.base.text;

/**
 * 
* @ClassName: CommonText 
* @Description: 本地数据库表常量 
* @date 2016/4/22 上午9:53:37 
*
 */
public class CommonText {
	
	public static final boolean DEBUG = true;//日志输出开关,true:打印输出，false:关闭打印输出
	public static final String LOGTAG = "CJLog";
	public static final boolean UNSECRET= true;//是否加密，false不加密；true加密
	public static final char SECRET='z';//加密密钥
	
//	public static String ENDPOINT=  "http://192.168.201.2:8020"; 
	public static String ENDPOINT=  "http://10.51.4.138:8020";
	
	// 数据库名称常量
	public static final String DATABASE_NAME = "IResume.db";
	
	// 数据库版本常量
	public static final int DATEBASE_VERSION = 1;
	
	public static final String USERINFO="userinfo";// 用户注册信息
	public static final String BASEINFO="baseinfo";// 基本信息
	public static final String WORKEXPERIENCE="work_experience";// 工作经历
	public static final String EVALUATION="evaluation";// 自我评价
	public static final String CHARACTER="character";// 自我评价
	public static final String JOBINTENSION="job_intension";// 求职意向
	public static final String EDUCATION="education";// 教育背景
	public static final String EDUCATION_TRAIN="education_train";// 培顺经历
	public static final String OTHERINFO="otherinfo";// 其他信息 （语言能力）
	public static final String OTHERINFO1="otherinfo1";// 其他信息 （证书）
	public static final String OTHERINFO2="otherinfo2";// 其他信息  （其他信息）
	
	public static final String PROJECT_EXPERIENCE = "project_experience"; // 项目经验
	public static final String PROFESSIONAL_SKILL = "professional_skill"; // 专业技能
	public static final String LEARNING_INSCHOOL = "learning_inschool"; // 在校学习情况
	public static final String PRACTICALEXPERIENCE_INSCHOOL = "practicalexperience_inschool"; // 在校实践经验
	
	public static final String COVER_FILE = "cover_file"; // cover文件下载
	public static final String MYCOLLECTION = "mycollection"; // 我的收藏
	public static final String MYWORDS = "mywords"; // 留言板
	
	public static final String TEMP_TABLE = "temp_table"; // 公用临时表
}
