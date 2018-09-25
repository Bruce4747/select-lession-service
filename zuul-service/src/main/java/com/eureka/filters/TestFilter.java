package com.eureka.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * 第一个pre类型的filter,prefilter01=true才能通过
 */
public class TestFilter extends ZuulFilter {

	/**
	 * filterType：该函数需要返回一个字符串来代表过滤器的类型，而这个类型就是在HTTP请求过程中定义的各个阶段。
	 * 在Zuul中默认定义了四种不同生命周期的过滤器类型，具体如下：
	 * pre：可以在请求被路由之前调用。
	 * routing：在路由请求时候被调用。
	 * post：在routing和error过滤器之后被调用。
	 * error：处理请求时发生错误时被调用。
	 * @return
	 */
	@Override
	public String filterType() {
		/**
		 * 过滤器类型
		 * 顺序: pre ->routing -> post ,以上3个顺序出现异常时都可以触发error类型的filter
		 */
		return FilterConstants.PRE_TYPE;
	}

	/**
	 * filterOrder：通过int值来定义过滤器的执行顺序，数值越小优先级越高。
	 * @return
	 */
	@Override
	public int filterOrder() {
		/**
		 * 同filterType类型中，order值越大，优先级越低
		 */
		return 0;
	}

	/**
	 * shouldFilter：返回一个boolean类型来判断该过滤器是否要执行。我们可以通过此方法来指定过滤器的有效范围。
	 * @return
	 */
	@Override
	public boolean shouldFilter() {
		/**
		 * 是否应该执行该过滤器，如果是false，则不执行该filter
		 */
		return false;
	}

	/**
	 * run：过滤器的具体逻辑。在该函数中，我们可以实现自定义的过滤逻辑，来确定是否要拦截当前的请求，
	 * 不对其进行后续的路由，或是在请求路由返回结果之后，对处理结果做一些加工等
	 * @return
	 */
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		String prefilter01 = request.getParameter("prefilter01");
		System.out.println("执行pre01Filter .....prefilter01=" + prefilter01 	);

		//如果用户名和密码都正确，则继续执行下一个filter
		if("true".equals(prefilter01) ){
			ctx.setSendZuulResponse(true);//会进行路由，也就是会调用api服务提供者
			ctx.setResponseStatusCode(200);
			ctx.set("isOK",true);//可以把一些值放到ctx中，便于后面的filter获取使用
		}else{
			ctx.setSendZuulResponse(false);//不需要进行路由，也就是不会调用api服务提供者
			ctx.setResponseStatusCode(401);
			ctx.set("isOK",false);//可以把一些值放到ctx中，便于后面的filter获取使用
			//返回内容给客户端
			ctx.setResponseBody("{\"result\":\"pre01Filter auth not correct!\"}");// 返回错误内容
		}

		return null;
	}
}
