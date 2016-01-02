/**
 * DASH Website Demo
 * a Website Demo supporting DASH media content upload, generate and watch.һ��֧��DASH�����ϴ������ɡ��ۿ�����վʾ����
 * dont support live DASH currently
 * 
 * Dependencies:
 * DASHEncoder2 (https://github.com/zhanghuicuc/DASHEncoder2) and FFmpeg 
 *
 * ����
 * Hui Zhang
 * �й���ý��ѧ/���ֵ��Ӽ���
 * Communication University of China/Digital Video Technology
 * 
 * zhanghuicuc@gmail.com
 * http://blog.csdn.net/nonmarking
 * 
 * this website is based on Lei Xiaohua's simplest video website
 */
package dao;

import java.util.List;


/**
 * @author ������
 * ��Object��DAO����
 * ������ͨ�õ�һЩ����
 */

public interface BaseDao {
	/**
	 * ����һ������
	 * @param object һ������
	 */
	public void save(Object object);

	 /**
	  * ����һ������
	  * @param object һ������
	  */
	public void update(Object object);
	
	 /**
	  * ɾ��һ������
	  * @param object һ������
	  */
	public void delete(Object object);
	
	 /**
	  * ���ݡ�����-ֵ����ȡһ��ָ�����͵Ķ���
	  * @param targetName ������������
	  * @param propertyName ���������Ե�����
	  * @param propertyValue ���������Ե�ֵ
	  * @return һ������
	  */
	public Object ReadSingle(String targetName,String propertyName,Object propertyValue);
	 /**
	  * ���ݡ�����-ֵ����ȡ���ָ�����͵Ķ���
	  * @param targetName ������������
	  * @param propertyName ���������Ե�����
	  * @param propertyValue ���������Ե�ֵ
	  * @return ������б�
	  */
	public List<Object> ReadByProperty(String targetName,String propertyName,Object propertyValue);
	 /**
	  * ��ȡָ�����͵����ж���
	  * @param targetName ������������
	  * @return ������б�
	  */
	public List<Object> ReadAll(String targetName);
	
	
	public List<Object> ReadByPropertyList(String targetName,String propertyName,Object propertyValue);

	/**
	 * ��ȡָ�����͵Ķ����������
	 * @param targetName ������������
	 * @return ����
	 */
	public Integer ReadCount(String targetName);
	 /**
	  * ���ݡ�����-ֵ��Ϊ��������ȡָ�����͵Ķ����������
	  * @param targetName ������������
	  * @param propertyName ���������Ե�����
	  * @param propertyValue ���������Ե�ֵ
	  * @return ����
	  */
	public Integer ReadCountByProperty(final String targetName,String propertyName, Object value);
	/**
	 * ��ȡ���ָ�����͵Ķ��󣬿����޶���ȡ������Ŀ�Ķ��٣����Ҹ����ض������Խ�������
	 * @param targetName ������������
	 * @param propertyName ���������Ե����ƣ���������
	 * @param num ��������б�������Ŀ
	 * @param order ����ʽ������ѡ��asc�����ߡ�desc��
	 * @return ������б�
	 */
	public List<Object> ReadLimitedByOrder(String targetName, String propertyName,int num, String order);
	/**
	 * �������ܣ�
	 * 1.���ݡ�����-ֵ����ȡ���ָ�����͵Ķ���
	 * 2.�޶���ȡ������Ŀ�Ķ��٣����Ҹ����ض������Խ�������
	 * @param targetName ������������
	 * @param readpropertyName ���������Ե����ƣ����ڻ�ȡ����
	 * @param readvalue ���������Ե�ֵ
	 * @param orderpropertyName ���������Ե����ƣ���������
	 * @param num ��������б�������Ŀ
	 * @param order ����ʽ������ѡ��asc�����ߡ�desc��
	 * @return
	 */
	public List<Object> ReadByPropertyAndLimitedByOrder(final String targetName, final String readpropertyName,
			final Object readvalue,final String orderpropertyName, final int num, final String order);
}
