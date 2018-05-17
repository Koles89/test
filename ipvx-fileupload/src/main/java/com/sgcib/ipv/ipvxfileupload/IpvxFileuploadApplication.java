package com.sgcib.ipv.ipvxfileupload;

import org.apache.commons.vfs2.FileChangeEvent;
import org.apache.commons.vfs2.FileListener;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;
import org.apache.commons.vfs2.impl.DefaultFileMonitor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IpvxFileuploadApplication {
	
	private static boolean inited = false;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(IpvxFileuploadApplication.class, args);
		System.out.println("hello springboot...");
		
		
			System.out.println("monitoring started..");
			IpvxFileuploadApplication.init();
			System.out.println("monitoring ended..");
		
	}
	
	/*public static void monitor() throws FileSystemException{
		
		FileSystemManager fsManager = VFS.getManager();
		 FileObject listendir = fsManager.resolveFile("E:\\zz\\test\\");
		 DefaultFileMonitor fm = new DefaultFileMonitor(new CustomFileListener());
		 fm.setRecursive(true);
		 fm.addFile(listendir);
		 fm.start();
	}*/
	
	public static void init() throws Exception {

		try{

			if(!inited){

				inited = true;

				FileSystemManager fsManager = VFS.getManager();
				 FileObject listendir = fsManager.resolveFile("E:\\zz\\test\\");
				 DefaultFileMonitor fm = new DefaultFileMonitor(new CustomFileListener());
				 fm.setRecursive(true);
				 fm.addFile(listendir);
				 fm.start();
					
				// prevents the app of exiting
				while(true){
					Thread.sleep(1000);
				}

			}

		}catch(Exception e){
			System.out.println("error");
		}

	}

	
	public static class CustomFileListener implements FileListener{
		
	

	@Override
	public void fileChanged(FileChangeEvent arg0) throws Exception {
		System.out.println("file is changed..");	
	}

	@Override
	public void fileCreated(FileChangeEvent arg0) throws Exception {
		System.out.println("file is created..");
	}

	@Override
	public void fileDeleted(FileChangeEvent arg0) throws Exception {
		System.out.println("file is deleted..");
		
	}
	
	}
}
