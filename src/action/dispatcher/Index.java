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
package action.dispatcher;

import java.util.ArrayList;
import java.util.List;

import service.BaseService;

import bean.Video;

import com.opensymphony.xwork2.ActionSupport;
/**
 * @author ������
 * Action
 */
public class Index extends ActionSupport {
	private List<Video> resultvideo;
	private List<Video> resultvideovod;
	private List<Video> resultvideolive;
	private BaseService baseService;

	public List<Video> getResultvideo() {
		return resultvideo;
	}

	public void setResultvideo(List<Video> resultvideo) {
		this.resultvideo = resultvideo;
	}

	public BaseService getBaseService() {
		return baseService;
	}

	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}

	public List<Video> getResultvideovod() {
		return resultvideovod;
	}

	public void setResultvideovod(List<Video> resultvideovod) {
		this.resultvideovod = resultvideovod;
	}

	public List<Video> getResultvideolive() {
		return resultvideolive;
	}

	public void setResultvideolive(List<Video> resultvideolive) {
		this.resultvideolive = resultvideolive;
	}

	public String execute(){
		try{
			//�����ʾһЩ����ͼ
			int count=baseService.ReadCountByProperty("Video", "islive", 0);
			List<Video> allvideo=baseService.ReadByProperty("Video","islive",0);
			//System.out.println(allvideo);
			resultvideo=new ArrayList();
			//ͼƬ����
			int num;
			if(count>6){
				num=6;
			}else{
				num=count;
			}
			for(int i=0;i<num;i++){
				//�����
				int idx=(int) (Math.random()*count);
				if(idx<count){
					Video video=allvideo.get(idx);
					resultvideo.add(video);
				}
			}
			//========================
			resultvideolive=baseService.ReadByPropertyAndLimitedByOrder("Video","islive",1,"edittime",4,"asc");
			resultvideovod=baseService.ReadByPropertyAndLimitedByOrder("Video","islive",0,"edittime",4,"asc");
			
			return SUCCESS;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
}
