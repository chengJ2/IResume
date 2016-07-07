package resume.me.com.base.util.common;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import resume.me.com.base.text.CommonText;
import resume.me.com.base.text.Dbsql;

/**
 * 
 * @ClassName: DatabaseHelper
 * @Description: 本地数据库帮助类
 * @date 2016/1/5 下午1:25:55
 * 
 */
public class DbHelper extends SQLiteOpenHelper {
	// 单例，在多线程读写数据库时进行同步
	private static DbHelper mInstance;

	public DbHelper(Context context) {
		super(context, CommonText.DATABASE_NAME, null,
				CommonText.DATEBASE_VERSION);
	}

	public static DbHelper getInstance(Context context) {
		if (mInstance == null) {
			mInstance = new DbHelper(context);
		}
		return mInstance;
	}

	public static void destoryInstance() {
		if (mInstance != null) {
			mInstance.close();
		}
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		MyLog.d("=====create tables=======");
		Dbsql sqls = new Dbsql();
		int size = sqls.createTableSql.length;
		for (int i = 0; i < size; i++) {
			db.execSQL(sqls.createTableSql[i]);
		}
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		MyLog.d("=====update tables=======");
	}
	
	/**
	 * 创建一个新的数据库
	 * 
	 * @param Sql
	 *            SQLITE 语句
	 * @param context
	 *            上下文对象
	 */
	public static void CreateNewSqlite(String Sql, Context context) {
		if (mInstance != null) {
			mInstance.getWritableDatabase().execSQL(Sql);
		} else {
			getInstance(context).getWritableDatabase().execSQL(Sql);

		}
	}

	/**
	 * 普通插入
	 * @param values
	 * @param table
	 */
	public boolean insertData(String table,ContentValues values) {
		SQLiteDatabase db = getWritableDatabase();
		long result = db.insert(table, null, values);
		if (result == -1) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 更新数据
	 * @param mContext 上下文
	 * @param mTableName 表名
	 * @param fieldName 字段名
	 * @param value 字段值
	 * @param whereArgs 更新条件
	 *  	1:userId 
	 *  	2.id & userId 
	 *  	3.tokenId & userId
	 * 
	 */
	public int updateData(Context mContext, String mTableName,
			String[] fieldName, String[] value,int whereArgs){
		SQLiteDatabase db = getWritableDatabase();
		int result = -1;
		try {
			ContentValues values = new ContentValues();
			int columnSize = fieldName.length;
			for (int i = 1; i < columnSize; i++) {
				values.put(fieldName[i],value[i]);
			}
			if(whereArgs == 1){
				result = db.update(mTableName, values, fieldName[0], 
						new String[]{value[0]});
			}else if(whereArgs == 2){
				result = db.update(mTableName, values, "id=? and userId=?", 
						new String[]{fieldName[0], value[0]});
			}else if(whereArgs == 3){
				result = db.update(mTableName, values, "tokenId=? and userId=?", 
						new String[]{fieldName[0], value[0]});
			}
			return result;
		} catch (Exception e) {
			MyLog.d("==updateData=="+e.getMessage());
		}
		return -1;
	}
	
	/**
	 * @param dataSetList
	 * @param table
	 * @category 异步操作数据库，插入数据时采用事物提高效率
	 */
	public void insertData(DataSetList dataSetList, String table) {
		SQLiteDatabase db = getWritableDatabase();
		int namesize = dataSetList.nameList.size();
		int valuesize = dataSetList.valueList.size();
		if (namesize > 0 && valuesize > 0) {
			int count = valuesize / namesize;// 行数
			try {
				db.beginTransaction();
				for (int i = 0; i < count; i++) {
					ContentValues values = new ContentValues();
					for (int j = 0; j < namesize; j++) {
						values.put(dataSetList.nameList.get(j),
								dataSetList.valueList.get(i * namesize + j));
					}
					db.insert(table, null, values);
				}
				db.setTransactionSuccessful();
			} catch (Exception e) {
				MyLog.d("=insertData="+e.getMessage());
			} finally {
				db.endTransaction();
			}
		}
	}

	/**
	 * 更新数据
	 * @param table
	 * @param where
	 */
	public void delete(String table, String where) {
		SQLiteDatabase db = getWritableDatabase();
		db.delete(table, where, null);
	}

	/**
	 * 更新数据
	 * @param sql
	 */
	public void delete(String sql) {
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL(sql);
	}
	
	/**
	 * 更新数据
	 * @param sql 完整的sql语句
	 * @return boolean
	 */
	public boolean update(String sql) {
		SQLiteDatabase db = getWritableDatabase();
		try {
			db.execSQL(sql);
			return true;
		} catch (Exception e) {
			MyLog.d(e.getMessage());
		} finally {
			if (db != null) {
				db.close();
			}
		}
		return false;
	}

	/**
	 * 查询
	 * @param table
	 * @param where
	 * @return Cursor
	 */
	public Cursor query(String table,String where) {
		Cursor cursor = null;
		SQLiteDatabase db = this.getReadableDatabase();
		cursor = db.query(table, null, where, null, null, null, null);
		return cursor;
	}
	
	/**
	 * 查询
	 * @param sql 完整的sql语句
	 * @return Cursor
	 */
	public Cursor query(String sql) {
		Cursor cursor = null;
		SQLiteDatabase db = this.getReadableDatabase();
		cursor = db.rawQuery(sql, null);
		return cursor;
	}

	/**
	 * 依表字段删除数据
	 * @param tableName
	 * @param column
	 * @param value
	 * @return boolean
	 */
	public boolean delete(String tableName, String field, String value) {
		SQLiteDatabase db = getWritableDatabase();
		try {
			db.delete(tableName, field + "=?", new String[] { value });
			return true;
		} catch (Exception e) {
			MyLog.d(e.getMessage());
		} finally {
			if (db != null) {
				db.close();
			}
		}
		return false;

	}
}
