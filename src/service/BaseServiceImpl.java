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

import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
/**
 * @author ������
 * ��Object��Service
 * ������һЩͨ�õķ���
 */
public class BaseServiceImpl implements BaseService {
	
	private BaseDao baseDao;
	@Override
	public void save(Object object) {
		// TODO Auto-generated method stub
		baseDao.save(object);
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		baseDao.update(object);
	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub
		baseDao.delete(object);
	}

	@Override
	public Object ReadByID(String targetName,int id) {
		// TODO Auto-generated method stub
		return baseDao.ReadSingle(targetName,"id", id);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List ReadAll(String targetName) {
		// TODO Auto-generated method stub
		return baseDao.ReadAll(targetName);
	}

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List ReadByProperty(String targetName, String propertyName,
			Object propertyValue) {
		// TODO Auto-generated method stub
		return baseDao.ReadByProperty(targetName, propertyName, propertyValue);
	}

	@Override
	public Object ReadSingle(String targetName, String propertyName,
			Object propertyValue) {
		// TODO Auto-generated method stub
		return baseDao.ReadSingle(targetName, propertyName, propertyValue);
	}

	@Override
	public List ReadLimitedByOrder(String targetName, String propertyName,
			int num, String order) {
		return baseDao.ReadLimitedByOrder(targetName,propertyName,num,order);
	}
	
	@Override
	public int ReadCount(String targetName) {
		// TODO Auto-generated method stub
		return baseDao.ReadCount(targetName);
	}

	@Override
	public int ReadCountByProperty(String targetName,String propertyName, Object value) {
		// TODO Auto-generated method stub
		return baseDao.ReadCountByProperty(targetName,propertyName,value);
	}

	@Override
	public List ReadByPropertyAndLimitedByOrder(String targetName,
			String readpropertyName, Object readvalue,
			String orderpropertyName, int num, String order) {
		return baseDao.ReadByPropertyAndLimitedByOrder(targetName, readpropertyName, readvalue,
				orderpropertyName, num, order);
	}

}
