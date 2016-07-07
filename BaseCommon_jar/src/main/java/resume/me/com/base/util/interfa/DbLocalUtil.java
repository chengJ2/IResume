package resume.me.com.base.util.interfa;

import java.util.List;
import java.util.Map;

import android.content.ContentValues;
import android.content.Context;

import resume.me.com.base.util.common.DataSetList;


/**
 * 
* @ClassName: DbLocalUtil 
* @Description: 本身数据操作接口
* @author Comsys-WH1510032 
* @date 2016/4/13 下午5:54:59 
*
 */
public interface DbLocalUtil {
	
	/**
	 * 
	 * @Title:DbLocalUtil
	 * @Description: 添加数据
	 * @author Comsys-WH1510032
	 * @param mContext
	 * @param mTableName
	 * @param values
	 * @return boolean
	 */
	public abstract boolean insertData(Context mContext, String mTableName,
									   ContentValues values);
	
	/**
	 * 
	 * @Title:DbLocalUtil
	 * @Description: 更新数据
	 * @author Comsys-WH1510032
	 * @param mContext
	 * @param mTableName
	 * @param values
	 * @return boolean
	 */
	public abstract int updateData(Context mContext, String mTableName,
								   String[] columnName, String[] value, int whereArgs);
	
	/**
	 * 
	 * @Title:DbLocalUtil
	 * @Description: 删除数据
	 * @author Comsys-WH1510032
	 * @return 返回类型  
	 * @param mContext
	 * @param where
	 */
	public abstract boolean updateData(Context mContext, String where);
	
	/**
	 * 
	 * @Title:DbLocalUtil
	 * @Description: 添加数据
	 * @author Comsys-WH1510032
	 * @return 返回类型  
	 * @param mContext
	 * @param mTableName
	 * @param dataSetList
	 */
	public abstract void insertDataSetList(Context mContext, String mTableName,
										   DataSetList dataSetList);
	
	/**
	 * 
	 * @Title:DbLocalUtil
	 * @Description: 查询数据
	 * @author Comsys-WH1510032
	 * @return 返回类型  
	 * @param mContext
	 * @param tableName
	 * @param where
	 * @return
	 */
	public abstract Map<String, String[]> queryData(Context mContext,
													String tableName, String where);

	/**
	 * 
	 * @Title:DbLocalUtil
	 * @Description: 查询数据
	 * @author Comsys-WH1510032
	 * @return 返回类型  
	 * @param mContext
	 * @param where
	 * @return
	 */
	public abstract Map<String, String[]> queryData(Context mContext,
													String where);
	
	/**
	 * 
	 * @Title:DbLocalUtil
	 * @Description: 查询数据
	 * @author Comsys-WH1510032
	 * @return 返回类型  
	 * @param mContext
	 * @param where
	 * @return
	 */
	public abstract Map<String, List<String>> queryDataForList(Context mContext,
															   String where);

	/**
	 * 
	 * @Title:DbLocalUtil
	 * @Description: 删除数据
	 * @author Comsys-WH1510032
	 * @return 返回类型  
	 * @param mContext
	 * @param where
	 */
	public abstract void deleteData(Context mContext, String where);
	
	/**
	 * 
	 * @Title:DbLocalUtil
	 * @Description: 根据某个字段删除数据
	 * @author Comsys-WH1510032
	 * @return 返回类型  
	 * @param mContext
	 * @param tableName
	 * @param columnName
	 * @param value
	 */
	public abstract boolean deleteByField(Context mContext, String tableName, String columnName, String value);
	
}
