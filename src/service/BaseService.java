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
package service;

import java.util.List;

/**
 * @author ������
 * ��Object��Service
 * ������һЩͨ�õķ���
 */
public interface BaseService {
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
	  * ����ID��ȡһ��ָ�����ƵĶ���
	  * @param targetName ���������
	  * @param id �����ID
	  * @return һ������
	  */
	 public Object ReadByID(String targetName,int id);
	 
	 @SuppressWarnings("rawtypes")
	 /**
	  * ��ȡָ�����͵����ж���
	  * @param targetName ������������
	  * @return ������б�
	  */
	 public List ReadAll(String targetName);
	 
	 @SuppressWarnings("rawtypes")
	 /**
	  * ���ݡ�����-ֵ����ȡ���ָ�����͵Ķ���
	  * @param targetName ������������
	  * @param propertyName ���������Ե�����
	  * @param propertyValue ���������Ե�ֵ
	  * @return ������б�
	  */
	 public List ReadByProperty(String targetName,String propertyName,Object propertyValue);

	 /**
	  * ���ݡ�����-ֵ����ȡһ��ָ�����͵Ķ���
	  * @param targetName ������������
	  * @param propertyName ���������Ե�����
	  * @param propertyValue ���������Ե�ֵ
	  * @return һ������
	  */
	 public Object ReadSingle(String targetName,String propertyName,Object propertyValue);
	 
	 /**
	  * ��ȡ���ָ�����͵Ķ��󣬿����޶���ȡ������Ŀ�Ķ��٣����Ҹ����ض������Խ�������
	  * @param targetName ������������
	  * @param propertyName ���������Ե����ƣ���������
	  * @param num ��������б��������Ŀ
	  * @param order ����ʽ������ѡ��asc�����ߡ�desc��
	  * @return ������б�
	  */
	 public List ReadLimitedByOrder(String targetName,String propertyName,int num,String order);
	 
	 /**
	  * ��ȡָ�����͵Ķ����������
	  * @param targetName ������������
	  * @return ����
	  */
	 public int ReadCount(String targetName);
	 /**
	  * ���ݡ�����-ֵ��Ϊ��������ȡָ�����͵Ķ����������
	  * @param targetName ������������
	  * @param propertyName ���������Ե�����
	  * @param propertyValue ���������Ե�ֵ
	  * @return ����
	  */
	public int ReadCountByProperty(final String targetName,String propertyName, Object value);
	/**
	 * �������ܣ�
	 * 1.���ݡ�����-ֵ����ȡ���ָ�����͵Ķ���
	 * 2.�޶���ȡ������Ŀ�Ķ��٣����Ҹ����ض������Խ�������
	 * @param targetName ������������
	 * @param readpropertyName ���������Ե����ƣ����ڻ�ȡ����
	 * @param readvalue ���������Ե�ֵ
	 * @param orderpropertyName ���������Ե����ƣ���������
	 * @param num ��������б��������Ŀ
	 * @param order ����ʽ������ѡ��asc�����ߡ�desc��
	 * @return
	 */
	public List ReadByPropertyAndLimitedByOrder(final String targetName, final String readpropertyName,
			final Object readvalue,final String orderpropertyName, final int num, final String order);

}