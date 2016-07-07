package resume.me.com.base.util.common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import resume.me.com.base.util.interfa.DbLocalUtil;


/**
 * 
 * @ClassName: DbLocalUtil
 * @Description: 本身数据操作接口实现
 * @author Comsys-WH1510032
 * @date 2016/4/13 下午5:54:59
 * 
 */
public class DbUtilImplement implements DbLocalUtil {

	@Override
	public boolean insertData(Context mContext, String mTableName,
			ContentValues values) {
		DbHelper db = DbHelper.getInstance(mContext);
		return db.insertData(mTableName, values);
	}
	
	@Override
	public int updateData(Context mContext, String mTableName,
			String[] fieldName, String[] value,int whereArgs) {
		DbHelper db = DbHelper.getInstance(mContext);
		return db.updateData(mContext, mTableName, fieldName, value,whereArgs);
	}
	
	@Override
	public boolean updateData(Context mContext, String where) {
		DbHelper db = DbHelper.getInstance(mContext);
		return db.update(where);
	}

	@Override
	public void insertDataSetList(Context mContext, String mTableName,
			DataSetList dataSetList) {
		// TODO Auto-generated method stub
		DbHelper db = DbHelper.getInstance(mContext);
		if (dataSetList != null) {
			db.insertData(dataSetList, mTableName);
		}
	}

	@Override
	public Map<String, String[]> queryData(Context mContext, String tableName,
			String where) {
		DbHelper db = DbHelper.getInstance(mContext);
		Map<String, String[]> map = new HashMap<String, String[]>();
		Cursor cur = db.query(where, tableName);
		if (cur.getCount() > 0) {
			if (cur.moveToFirst()) {
				String names[] = cur.getColumnNames();
				int namesize = names.length;
				int rows = cur.getCount();
				String list[][] = new String[namesize][rows];
				int k = 0;
				do {
					for (int i = 0; i < namesize; i++) {
						list[i][k] = (cur.getString(i) == null) ? "" : cur
								.getString(i).toString();
					}
					k++;
				} while (cur.moveToNext());

				for (int j = 0; j < namesize; j++) {
					map.put(names[j], list[j]);
				}
			}
		} else {
			map = null;
		}
		cur.close();
		return map;
	}
	
	@Override
	public Map<String, List<String>> queryDataForList(Context mContext,String where) {
		DbHelper db = DbHelper.getInstance(mContext);
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		Cursor cur = db.query(where);
		if (cur.getCount() > 0) {
			if (cur.moveToFirst()) {
				String names[] = cur.getColumnNames();
				int namesize = names.length;
				int rows = cur.getCount();
				String list[][] = new String[namesize][rows];
				int k = 0;
				do {
					for (int i = 0; i < namesize; i++) {
						list[i][k] = (cur.getString(i) == null) ? "" : cur
								.getString(i).toString();
					}
					k++;
				} while (cur.moveToNext());

				for (int j = 0; j < namesize; j++) {
					map.put(names[j], Arrays.asList(list[j]));
				}
			}
		} else {
			map = null;
		}
		cur.close();
		return map;
	}

	@Override
	public Map<String, String[]> queryData(Context mContext, String where) {
		DbHelper db = null;
		Map<String, String[]> map = null;
		Cursor cur = null;
		try {
			db = DbHelper.getInstance(mContext);
			map = new HashMap<String, String[]>();
			cur = db.query(where);
			if (cur.getCount() > 0) {
				if (cur.moveToFirst()) {
					String names[] = cur.getColumnNames();
					int namesize = names.length;
					int rows = cur.getCount();
					String list[][] = new String[namesize][rows];
					int k = 0;
					do {
						for (int i = 0; i < namesize; i++) {
							list[i][k] = (cur.getString(i) == null) ? "" : cur
									.getString(i).toString();
						}
						k++;
					} while (cur.moveToNext());

					for (int j = 0; j < namesize; j++) {
						map.put(names[j], list[j]);
					}
				}
			} else {
				map = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (cur != null) {
				cur.close();
			}
			if (db != null) {
				db.close();
			}
		}
		return map;
	}

	@Override
	public void deleteData(Context mContext, String where) {
		DbHelper db = DbHelper.getInstance(mContext);
		try {
			db.delete(where);
		} catch (Exception e) {
			MyLog.d(e.getMessage());
		}
	}
	
	@Override
	public boolean deleteByField(Context mContext, String tableName,
			String columnName, String value) {
		DbHelper db = DbHelper.getInstance(mContext);
		return db.delete(tableName, columnName + "=?", value );
	}

}
