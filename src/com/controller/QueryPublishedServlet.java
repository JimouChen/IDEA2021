package com.controller;

import com.entity.CarMsg;
import com.service.UserService;
import com.service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/publishedMsg.do")
public class QueryPublishedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        HttpSession session = request.getSession();
        int user_id = (int) session.getAttribute("userid");

        List<CarMsg> carMsg = userService.showPublishedCarMsg((user_id));
        request.setAttribute("selfCarMsg", carMsg);
        request.getRequestDispatcher("/Pages/selfPublished.jsp").forward(request, response);
    }
}
