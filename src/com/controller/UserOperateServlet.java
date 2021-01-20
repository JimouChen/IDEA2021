package com.controller;

import com.entity.AnsComment;
import com.entity.CarMsg;
import com.entity.Comment;
import com.entity.OtherCarsMsg;
import com.service.UserService;
import com.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("*.car")
public class UserOperateServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        String methodName = servletPath.substring(1, servletPath.length() - 4);
        System.out.println(methodName);
        try {
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void updateMsg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int carId = Integer.parseInt(request.getParameter("car_id"));
        HttpSession session = request.getSession();
        session.setAttribute("carId", carId);
        request.getRequestDispatcher("/Pages/changeCarMsg.jsp").forward(request, response);

    }

    protected void receiveNewMsg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int carId = (int) session.getAttribute("carId");
        //页面得到的车信息和价格
        String msg = request.getParameter("carMsg");
        double price = Double.parseDouble(request.getParameter("money"));
        userService.updateCarMsg(carId, msg, price);
        showSelfCarMsg(request, response);
//        request.getRequestDispatcher("/Pages/userBackstage.jsp").forward(request, response);
    }

    protected void publishNewCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int carId = Integer.parseInt(request.getParameter("car_id"));
        userService.publishCar(carId);
        showSelfCarMsg(request, response);
        System.out.println("发布成功");
    }

    protected void addCarMsg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int user_id = (int) session.getAttribute("userid");
        String msg = request.getParameter("newCarMsg");
        double price = Double.parseDouble(request.getParameter("price"));

        userService.addNewCar(user_id, msg, price);
        showSelfCarMsg(request, response);
        System.out.println("新增车信息成功");
    }

    protected void showSelfCarMsg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //回到未发布的车信息页
        UserService userService = new UserServiceImpl();
        HttpSession session = request.getSession();
        int user_id = (int) session.getAttribute("userid");

        List<CarMsg> carMsg = userService.showSelfCarMsg((user_id));
        request.setAttribute("selfCarMsg", carMsg);
        request.getRequestDispatcher("/Pages/saleInfo.jsp").forward(request, response);
        System.out.println(carMsg);
    }

    //查看别人的二手车
    protected void lookOthersCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int user_id = (int) session.getAttribute("userid");
        List<OtherCarsMsg> otherCarsMsg = userService.queryOtherCar(user_id);
        request.setAttribute("otherCar", otherCarsMsg);
        request.getRequestDispatcher("/Pages/queryOtherCars.jsp").forward(request, response);

    }

    protected void commentCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int carId = Integer.parseInt(request.getParameter("car_id"));
        HttpSession session = request.getSession();
        session.setAttribute("the_car", carId);
        request.getRequestDispatcher("/Pages/comment.jsp").forward(request, response);
    }

    protected void saveComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int carId = (int) session.getAttribute("the_car");
        int user_id = (int) session.getAttribute("userid");
        String com = request.getParameter("comm");
        System.out.println("carId is " + carId);
        System.out.println("userId is " + user_id);
        System.out.println("comm is " + com);
        //调用
        userService.insertComment(carId, user_id, com);
        lookOthersCar(request, response);
        System.out.println("留言成功");
    }

    //回到已发布页面
    protected void backPublished(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        HttpSession session = request.getSession();
        int user_id = (int) session.getAttribute("userid");

        List<CarMsg> carMsg = userService.showPublishedCarMsg((user_id));
        request.setAttribute("selfCarMsg", carMsg);
        request.getRequestDispatcher("/Pages/selfPublished.jsp").forward(request, response);
    }

    //查看留言
    protected void queryComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int user_id = (int) session.getAttribute("userid");
        List<Comment> comments = userService.queryComment(user_id);
        request.setAttribute("Comment", comments);
        request.getRequestDispatcher("/Pages/showComment.jsp").forward(request, response);
    }

    //回复留言saveAnsComment
    protected void ansComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int carId = Integer.parseInt(request.getParameter("car_id"));
        HttpSession session = request.getSession();
        session.setAttribute("ans_car", carId);
        request.getRequestDispatcher("/Pages/ansComment.jsp").forward(request, response);
    }

    protected void saveAnsComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int carId = (int) session.getAttribute("ans_car");
        int user_id = (int) session.getAttribute("userid");
        String com = request.getParameter("ansComm");

        //调用
        userService.ansComment(carId, user_id, com);
        queryComment(request, response);
        System.out.println("回复留言成功");
    }

    //查看自己的留言回复
    protected void querySelfComment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userid");
        List<AnsComment> ansComments = userService.queryAnsCom(userId);
        request.setAttribute("AnsCom", ansComments);
        request.getRequestDispatcher("/Pages/queryAnsCom.jsp").forward(request, response);
    }
}
