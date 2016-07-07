package resume.me.com.base.text;

/**
 * 程序中用到的sql语句
 * @author ChengJian
 *
 */
public class Dbsql {
	// 用户注册信息
	String userinfo_aql = "create table "
			+ CommonText.USERINFO
			+ "(id integer primary key autoincrement,uid TEXT,username TEXT,userpassword TEXT,deviceId TEXT,patform TEXT,temp TEXT,temp2 TEXT,createtime TEXT,updatetime TEXT,lastlogintime TEXT,userstatus TEXT DEFAULT 0)";
	// 用户基本信息
	String baseinfo_aql = "create table "
			+ CommonText.BASEINFO
			+ "(id integer primary key autoincrement,userId TEXT,nickname TEXT, realname TEXT, gender TEXT,"
			+ "phone TEXT,brithday TEXT, joinworktime TEXT, hometown TEXT, city TEXT,email TEXT,"
			+ " ismarry TEXT,nationality TEXT,license TEXT,workingabroad TEXT,politicalstatus TEXT,avator TEXT, bgcolor TEXT,createtime TEXT,updatetime TEXT,temp TEXT)";
	// 工作经历数据
	String work_experience_aql = "create table "
			+ CommonText.WORKEXPERIENCE
			+ "(id integer primary key autoincrement,tokenId TEXT,userId TEXT, companyname TEXT,companynature TEXT,companyscale TEXT, industryclassification TEXT,"
			+ "jobtitle TEXT, worktimestart TEXT,worktimeend TEXT, expectedsalary TEXT, workdesc TEXT,bgcolor TEXT,temp TEXT,createtime TEXT,updatetime TEXT)";
	
	// 自我评价
	String evaluation_aql = "create table "
			+ CommonText.EVALUATION
			+ "(id integer primary key autoincrement,tokenId TEXT,userId TEXT, selfevaluation TEXT, careergoal TEXT,character TEXT,bgcolor TEXT,temp TEXT,createtime TEXT,updatetime TEXT)";
	
	// 个人性格
	String character_aql = "create table "
			+ CommonText.CHARACTER
			+ "(id integer primary key autoincrement,userId TEXT,character TEXT,temp TEXT)";
	
	
	// 求职意向数据
	String job_intension_aql = "create table "
			+ CommonText.JOBINTENSION
			+ "(id integer primary key autoincrement,tokenId TEXT,userId TEXT, expworkingproperty TEXT, expdworkplace TEXT,"
			+ " expworkindustry TEXT,expworkcareer TEXT,expmonthlysalary TEXT,workingstate TEXT,bgcolor TEXT,temp TEXT,createtime TEXT,updatetime TEXT)";
	
	// 教育经历
	String education_aql = "create table "
			+ CommonText.EDUCATION
			+ "(id integer primary key autoincrement,tokenId TEXT,userId TEXT, educationtimestart TEXT,educationtimeend TEXT, school TEXT,"
			+ " examination TEXT,majorname TEXT,degree TEXT,bgcolor TEXT,temp TEXT,createtime TEXT,updatetime TEXT)";
	// 培顺经历
	String training_aql = "create table "
			+ CommonText.EDUCATION_TRAIN
			+ "(id integer primary key autoincrement,tokenId TEXT,userId TEXT, trainingtimestart TEXT,trainingtimeend TEXT, trainingorganization TEXT,"
			+ " trainingclass TEXT,certificate TEXT,description TEXT,bgcolor TEXT,temp TEXT,createtime TEXT,updatetime TEXT)";
	
	
	String otherinfo_aql = "create table "
			+ CommonText.OTHERINFO
			+ "(id integer primary key autoincrement,tokenId TEXT,userId TEXT, language TEXT, literacyskills TEXT,"
			+ " listeningspeaking TEXT,bgcolor TEXT,temp TEXT,createtime TEXT,updatetime TEXT)";
	
	String otherinfo1_aql = "create table "
			+ CommonText.OTHERINFO1
			+ "(id integer primary key autoincrement,tokenId TEXT,userId TEXT, certificate TEXT, certificatetime TEXT,temp TEXT,"
			+ " createtime TEXT,updatetime TEXT)";
	
	String otherinfo2_aql = "create table "
			+ CommonText.OTHERINFO2
			+ "(id integer primary key autoincrement,tokenId TEXT,userId TEXT, title TEXT, description TEXT,temp TEXT,"
			+ " createtime TEXT,updatetime TEXT)";
	
	// 项目经验
	String project_experience_aql = "create table "
			+ CommonText.PROJECT_EXPERIENCE
			+ "(id integer primary key autoincrement,tokenId TEXT,userId TEXT, projectname TEXT, worktimestart TEXT,worktimeend TEXT,"
			+ " duties TEXT, prokectdesc TEXT,bgcolor TEXT,temp TEXT,createtime TEXT,updatetime TEXT)";
	
	String professional_skill_aql = "create table "
			+ CommonText.PROFESSIONAL_SKILL
			+ "(id integer primary key autoincrement,tokenId TEXT,userId TEXT, skillname TEXT, usetime TEXT,skillful TEXT,"
			+ "temp TEXT,createtime TEXT,updatetime TEXT)";
	
	String learning_inschool_aql = "create table "
			+ CommonText.LEARNING_INSCHOOL
			+ "(id integer primary key autoincrement,tokenId TEXT,userId TEXT, awardedlevel TEXT, activity_duties_desc TEXT,awards TEXT,"
			+ " award_level TEXT, getime TEXT,desc TEXT,temp TEXT,createtime TEXT,updatetime TEXT)";
	
	String practicalexperience_inschool_aql = "create table "
			+ CommonText.PRACTICALEXPERIENCE_INSCHOOL
			+ "(id integer primary key autoincrement,tokenId TEXT,userId TEXT, practicalname TEXT, practicaltimestart TEXT,practicaltimeend TEXT,"
			+ " practicaldesc TEXT, temp TEXT,createtime TEXT,updatetime TEXT)";
	
	String mycollection_sql = "create table "
			+ CommonText.MYCOLLECTION
			+ "(id integer primary key autoincrement,cId TEXT,userId TEXT,topicId TEXT,title TEXT,content TEXT,from_url TEXT,site_name TEXT,link_site TEXT,"
			+ "shareUserId TEXT,sharename TEXT,sharenamecity TEXT,createtime TEXT,type TEXT,temp TEXT)";
	
	
	String coverfile_sql = "create table "
			+ CommonText.COVER_FILE
			+ "(id integer primary key autoincrement,filename TEXT, fileurl TEXT,length text, isfinish TEXT DEFAULT 0,temp TEXT)";
	
	String mywords_sql = "create table "
			+ CommonText.MYWORDS
			+ "(id integer primary key autoincrement,word TEXT,type TEXT,createtime TEXT,temp TEXT)";
	
	String temp_sql = "create table "
			+ CommonText.TEMP_TABLE
			+ "(id integer primary key autoincrement,temp TEXT,temp1 TEXT,temp2 TEXT,temp3 TEXT,temp4 TEXT,temp5 TEXT,temp6 TEXT,temp7 TEXT,temp8 TEXT)";
	
	/* 创建数据库表的语句 */
	public String createTableSql[] = {userinfo_aql,baseinfo_aql,
				work_experience_aql,evaluation_aql,character_aql,education_aql,training_aql,job_intension_aql,
				otherinfo_aql,otherinfo1_aql,otherinfo2_aql,
				project_experience_aql,professional_skill_aql,learning_inschool_aql,practicalexperience_inschool_aql,
				mycollection_sql,mywords_sql,coverfile_sql,
				temp_sql};

}
