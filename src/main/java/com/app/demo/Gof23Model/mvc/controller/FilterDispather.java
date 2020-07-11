package com.app.demo.Gof23Model.mvc.controller;


import com.app.demo.Gof23Model.mvc.action.ActionDispather;
import com.app.demo.Gof23Model.mvc.action.IActionDispather;
import com.app.demo.Gof23Model.mvc.helper.ValueStackHelper;
import com.app.demo.Gof23Model.mvc.valuestack.ValueStack;
import com.app.demo.Gof23Model.mvc.view.ViewManager;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



/**
 * @author cbf4Life cbf4life@126.com
 * I'm glad to share my knowledge with you all.
 */
public class FilterDispather implements Filter {
	//定义一个值栈辅助类
	private ValueStackHelper valueStackHelper = new ValueStackHelper();
	//应用IActionDispather
	IActionDispather actionDispather = new ActionDispather();
	
	
	//server销毁时要做的事情
	public void destroy() {

	}

	//过滤器必须实现的
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
	
		//转换为HttpServletRequest
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		//传递到其他过滤器处理
		chain.doFilter(req, res);
		//获得从HTTP请求的ACTION名称
		String actionName = getActionNameFromURI(req);		
		//对ViewManager的应用
		ViewManager viewManager = new ViewManager(actionName);
		//所有参数放入值栈
		ValueStack valueStack = valueStackHelper.putIntoStack(req);
		//把所有的请求传递给ActionDispatcher处理
		String result =actionDispather.actionInvoke(actionName);
		String viewPath = viewManager.getViewPath(result);
		//直接转向
		RequestDispatcher rd = req.getRequestDispatcher(viewPath);
		rd.forward(req, res);
	}

	public void init(FilterConfig arg0) throws ServletException {
		/*
		 * 1、检查XML配置文件是否正确
		 * 2、启动监控程序，观察配置文件是否正确
		 */
	}
	
	//通过url获得actionName
	private String getActionNameFromURI(HttpServletRequest req){
		String path = (String) req.getRequestURI();
		String actionName = path.substring(path.lastIndexOf("/") + 1,path.lastIndexOf("."));
		return actionName;
	}
	
}