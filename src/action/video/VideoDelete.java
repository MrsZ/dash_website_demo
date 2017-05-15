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
package action.video;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import service.BaseService;
import bean.Video;

import com.opensymphony.xwork2.ActionSupport;
/**
 * @author ������,����
 * ɾ����Ƶ��Action
 */
public class VideoDelete extends ActionSupport {
	private int videoid;
	private BaseService baseService;
	public int getVideoid() {
		return videoid;
	}

	public void setVideoid(int videoid) {
		this.videoid = videoid;
	}
	
	public BaseService getBaseService() {
		return baseService;
	}

	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}

	public String execute(){
		try{
			Video video=(Video) baseService.ReadByID("Video", videoid);
			//���·��
			String thumbnailPath=video.getThumbnailurl();
			String dashfilepath=video.getDashfileurl();
			String oripath=video.getOriurl();
			String logpath=video.getLogurl();
			//��ȡ��·��������·����
			String thumbnailrealpath=ServletActionContext.getServletContext().getRealPath("/").replace('\\', '/')
					+thumbnailPath;
			String dashfilerealpath=ServletActionContext.getServletContext().getRealPath("/").replace('\\', '/')
					+dashfilepath;
			String orirealpath=ServletActionContext.getServletContext().getRealPath("/").replace('\\', '/')
					+oripath;
			String logrealpath=ServletActionContext.getServletContext().getRealPath("/").replace('\\', '/')
					+logpath;
			File thumbnailfile=new File(thumbnailrealpath);
			File dashfile=new File(dashfilerealpath);
			File orivideofile=new File(orirealpath);
			File logfile=new File(logrealpath);
			//ɾ����֮��صĽ�ͼ�ļ�����Ƶ�ļ�
			if(thumbnailfile!=null){
				thumbnailfile.delete();
			}
			if(dashfile!=null){
				String dashfiledelcommand="cmd /c rmdir /s/q "+"\""+dashfilerealpath+"\" ";
				System.out.println(dashfiledelcommand);
				Process process=Runtime.getRuntime().exec(dashfiledelcommand);
				BufferedInputStream in = new BufferedInputStream(process.getInputStream());  
				BufferedReader inBr = new BufferedReader(new InputStreamReader(in));  
				String lineStr;  
				while ((lineStr = inBr.readLine()) != null)  
						System.out.println(lineStr);
				if (process.waitFor() != 0) {  
					if (process.exitValue() == 1)//p.exitValue()==0��ʾ����������1������������  
						System.err.println("Delete dash files Failed!");  
				} 
				inBr.close();  
				in.close();
			}
			if(orivideofile!=null){
				orivideofile.delete();
			}
			if(logfile!=null){
				String logfiledelcommand="cmd /c rmdir /s/q "+"\""+logrealpath+"\" ";
				System.out.println(logfiledelcommand);
				Process process=Runtime.getRuntime().exec(logfiledelcommand);
				BufferedInputStream in = new BufferedInputStream(process.getInputStream());  
				BufferedReader inBr = new BufferedReader(new InputStreamReader(in));  
				String lineStr;  
				while ((lineStr = inBr.readLine()) != null)  
						System.out.println(lineStr);
				if (process.waitFor() != 0) {  
					if (process.exitValue() == 1)//p.exitValue()==0��ʾ����������1������������  
						System.err.println("Delete log files Failed!");  
				} 
				inBr.close();  
				in.close();
			}
			//����ɾ���ü�¼
			baseService.delete(video);
			return SUCCESS;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return ERROR;
		}
	}
}
