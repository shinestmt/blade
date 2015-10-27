/**
 * Copyright (c) 2015, biezhi 王爵 (biezhi.me@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.blade.render;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blade.Blade;
import com.blade.BladeWebContext;
import com.blade.servlet.Response;

import blade.kit.log.Logger;
/**
 * 渲染器抽象类
 * 
 * @author	<a href="mailto:biezhi.me@gmail.com" target="_blank">biezhi</a>
 * @since	1.0
 */
public abstract class Render {
	
	private static final Logger LOGGER = Logger.getLogger(Render.class);
	
	protected Blade blade = Blade.me();
	
	static final String VIEW_NOTFOUND = "<html><head><title>404 Not Found</title></head><body bgcolor=\"white\"><center><h1>[ %s ] Not Found</h1></center><hr><center>blade "
			+ Blade.VERSION +"</center></body></html>";
	
	public void render404(String viewName){
		render404(null, viewName);
	}
	
	/**
	 * 404视图
	 * 
	 * @param response		Responsee对象
	 * @param viewName		视图名称
	 */
	public void render404(Response response, String viewName){
        try {
        	String view404 = blade.view404();
        	if(null != view404){
        		ModelAndView modelAndView = new ModelAndView(view404);
        		modelAndView.add("viewName", viewName);
        		render(modelAndView);
        	} else {
        		if(null == response){
        			response = BladeWebContext.response();
        		}
        		response.contentType("text/html; charset=utf-8");
        		response.status(404);
    			ServletOutputStream outputStream = response.outputStream();
    			outputStream.print(String.format(VIEW_NOTFOUND, viewName));
    			outputStream.flush();
    			outputStream.close();
			}
		} catch (IOException e) {
			LOGGER.error(e);
		}
	}
	
	/**
	 * 渲染500视图
	 * 
	 * @param bodyContent	错误消息
	 */
	public void render500(String bodyContent){
	    try {
	    	
	    	String view500 = blade.view500();
        	if(null != view500){
        		ModelAndView modelAndView = new ModelAndView(view500);
        		modelAndView.add("body", bodyContent);
        		render(modelAndView);
        	} else {
        		HttpServletResponse httpResponse = BladeWebContext.servletResponse();
    	    	
    	    	httpResponse.setContentType("text/html; charset=utf-8");
    			ServletOutputStream outputStream = httpResponse.getOutputStream();

    			outputStream.print(bodyContent.toString());
    			outputStream.flush();
    			outputStream.close();
			}
		} catch (IOException e) {
			LOGGER.error(e);
		}
	}
	
	/**
     * 输出json
     * 
     * @param json	json内容
     */
    public void json(String json){
    	if(null != json){
    		HttpServletResponse response = BladeWebContext.servletResponse();
    		HttpServletRequest request = BladeWebContext.servletRequest();
    		
    		response.setHeader("Cache-Control", "no-cache");
    		String userAgent = request.getHeader("User-Agent");
    		if (userAgent.contains("MSIE")) {
    			response.setContentType("text/html;charset=utf-8");
    		} else {
    			response.setContentType("application/json;charset=utf-8");
    		}
    		try {
    			request.setCharacterEncoding("utf-8");
    			PrintWriter out = response.getWriter();
    			out.print(json.toString());
        		out.flush();
        		out.close();
    		} catch (UnsupportedEncodingException e1) {
    			e1.printStackTrace();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    /**
     * 输出text
     * @param text	text内容
     */
    public void text(String text){
    	if(null != text){
    		HttpServletResponse response = BladeWebContext.servletResponse();
    		HttpServletRequest request = BladeWebContext.servletRequest();
    		response.setHeader("Cache-Control", "no-cache");
    		response.setContentType("text/plain;charset=utf-8");
    		try {
    			request.setCharacterEncoding("utf-8");
    			PrintWriter out = response.getWriter();
    			out.print(text);
        		out.flush();
        		out.close();
    		} catch (UnsupportedEncodingException e1) {
    			e1.printStackTrace();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    /**
     * 输出xml
     * @param xml	xml内容	
     */
    public void xml(String xml){
    	if(null != xml){
    		HttpServletResponse response = BladeWebContext.servletResponse();
    		HttpServletRequest request = BladeWebContext.servletRequest();
    		response.setHeader("Cache-Control", "no-cache");
    		response.setContentType("text/xml;charset=utf-8");
    		try {
    			request.setCharacterEncoding("utf-8");
    			PrintWriter out = response.getWriter();
    			out.print(xml);
        		out.flush();
        		out.close();
    		} catch (UnsupportedEncodingException e1) {
    			e1.printStackTrace();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    /**
     * 输出HTML
     * @param html	html内容	
     */
    public void html(String html){
    	if(null != html){
    		HttpServletResponse response = BladeWebContext.servletResponse();
    		HttpServletRequest request = BladeWebContext.servletRequest();
    		response.setHeader("Cache-Control", "no-cache");
    		response.setContentType("text/html;charset=utf-8");
    		try {
    			request.setCharacterEncoding("utf-8");
    			PrintWriter out = response.getWriter();
    			out.print(html);
        		out.flush();
        		out.close();
    		} catch (UnsupportedEncodingException e1) {
    			e1.printStackTrace();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    /**
     * 输出javascript
     * @param javascript 	js内容
     */
    public void javascript(String javascript){
    	if(null != javascript){
    		HttpServletResponse response = BladeWebContext.servletResponse();
    		HttpServletRequest request = BladeWebContext.servletRequest();
    		response.setHeader("Cache-Control", "no-cache");
    		response.setContentType("text/javascript;charset=utf-8");
    		try {
    			request.setCharacterEncoding("utf-8");
    			PrintWriter out = response.getWriter();
    			out.print(javascript);
        		out.flush();
        		out.close();
    		} catch (UnsupportedEncodingException e1) {
    			e1.printStackTrace();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    }
    
	/**
	 * 处理视图
	 * @param view	视图名称
	 * @return		返回取出多余"/"的全路径
	 */
	protected String disposeView(String view){
		if(null != view){
			view = blade.viewPrefix() + view;
			view = view.replaceAll("[/]+", "/");
			if(!view.endsWith(blade.viewSuffix())){
				view = view + blade.viewSuffix();
			}
		}
		return view;
	}
	
	/**
	 * 渲染方法
	 * @param view	视图名称
	 * @return		null
	 */
	public abstract Object render(final String view);
	
	/**
	 * 渲染方法
	 * @param modelAndView	modelAndView对象
	 * @return				null
	 */
	public abstract Object render(ModelAndView modelAndView);

}
