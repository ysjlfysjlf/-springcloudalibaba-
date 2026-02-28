package demo.helloconsumer.controller;

//import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
//import com.alibaba.csp.sentinel.slots.block.BlockException;
//import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
//import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
//import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
//import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
//import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//public class SentinelExceptionHandler implements BlockExceptionHandler {
//    @Override
//    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException ex) throws Exception {
//        String msg="未知异常";
//        int status=429;
//
//        if(ex instanceof FlowException){
//            msg="请求被限流了";
//        }else if(ex instanceof ParamFlowException){
//            msg="请求被热点参数限流";
//        }else if(ex instanceof DegradeException){
//            msg="请求被熔断降级了";
//        }else if(ex instanceof SystemBlockException){
//            msg="系统入口流量被限流了";
//        }else if(ex instanceof AuthorityException){
//            msg="没有权限访问";
//            status=401;
//        }
//        response.setContentType(
//                "application/json;charset=utf-8");
//        response.setStatus(status);
//        response.getWriter().println("{\"msg\":\""+msg+"\",\"status\":"+status+"}");
//    }
//}
