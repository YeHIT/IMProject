package cn.yesomething.utils;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@MappedTypes(value = {String[].class})
public class StringArrayTypeHandler extends BaseTypeHandler<String[]> {
    String separator = ",";

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String[] strings, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, StringHelper.join(strings, separator));
    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String resultString = resultSet.getString(s);
        return getResultStringArray(resultString);
    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String resultString = resultSet.getString(i);
        return getResultStringArray(resultString);
    }

    @Override
    public String[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String resultString = callableStatement.getString(i);
        return getResultStringArray(resultString);
    }

    /**
     * 把结果字符串按分隔符拆分为字符串数组
     * @param resultString 结果字符串
     * @return 拆分得到的字符串数组
     */
    public String[] getResultStringArray(String resultString){
        if (resultString != null && resultString.length() > 0) {
            String[] results = resultString.split(separator);
            List<String> resultList = new ArrayList<>(results.length);
            for (String result : results) {
                if (result != null && result.length() > 0) {
                    resultList.add(result);
                }
            }
            return resultList.toArray(new String[resultList.size()]);
        }
        return null;
    }

}
