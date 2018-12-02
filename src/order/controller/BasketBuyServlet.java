package order.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.JsonArray;

import basket.model.service.BasketService;
import basket.model.vo.Basket;
import member.model.service.MemberService;
import member.model.vo.Address;

/**
 * Servlet implementation class BasketBuyServlet
 */
@WebServlet("/buy/basketBuy")
public class BasketBuyServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public BasketBuyServlet() {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {      
      JSONArray data = new JSONArray();
     
      int memberNo = Integer.parseInt(request.getParameter("memberNo"));
      String[] bookNoArray = request.getParameterValues("bookNoArray");

      // amounts 는 반복문 써서 integer.parseint해서 배열에 넣어주면 됨.
      String[] amountArray = request.getParameterValues("amountArray");
      String[] bookStatusArray = request.getParameterValues("bookStatusArray");
      String[] bookPriceArray = request.getParameterValues("bookPriceArray");
      

      int[] price = new int[bookPriceArray.length];
      int[] amount = new int[amountArray.length];
      
      for (int i = 0; i < bookNoArray.length; i++) {
         JSONObject obj = new JSONObject();
         JSONArray arr = new JSONArray();
         
         price[i] = Integer.parseInt(bookPriceArray[i]);
         amount[i] = Integer.parseInt(amountArray[i]);
         
         obj.put("bookNo", bookNoArray[i]);         
         obj.put("amount", amount[i]);         
         obj.put("bookStatus", bookStatusArray[i]);
         obj.put("price", price[i]);
         // obj.put("address", add);
         obj.put("memberNo", memberNo);
         arr.add(obj);
         
         data.add(arr);
      }
      
      String dataStr = data.toJSONString();

      response.setContentType("application/json; charset=utf-8");
      PrintWriter out = response.getWriter();

      out.print(data);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}