<%@ page import="bean.Person" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Winterfell
  Date: 2021/11/1
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>EL表达式输出普通Bean对象</h1>

<%
    Person person = new Person();
    person.setName("张三");
    person.setAge(21);
    person.setPhones(new String[]{"123", "465", "678"});
    person.setList(Arrays.asList("篮球", "足球", "游泳"));
    HashMap<String, Integer> map = new HashMap<>();
    map.put("father", 56);
    map.put("mother", 54);
    map.put("sister", 29);
    person.setMap(map);

    pageContext.setAttribute("person", person);
%>

<%--
    EL表达式输出普通Bean对象
    注:
        ①EL 对象.属性是通过对象的getXXX方法来获取的,即类中如果没有get方法,则无法获取
         该属性,从而出错
        ②若成员为数组,可以通过下标找到数组的某个值
        ③若成员为List,既可以通过下标,也可以通过get(int index>)
--%>
获取person对象:${person} <br/>
<%--获取person对象的name属性:${person.username}<br/>--%>
获取person对象的age属性:${person.age}<br/>

获取person对象的数组:${person.phones}<br/>
获取person对象的数组中的某个值:${person.phones[1]}<br/>

获取person对象的List集合:${person.list}<br/>
获取person对象的List集合的某个元素:${person.list[1]}<br/>
获取person对象的List集合的某个元素:${person.list.get(2)}<br/>

获取person对象的Map集合:${person.map}<br/>
获取person对象的Map集合的某个键值对:${person.map.father}<br/>
获取person对象的Map集合的某个键值对:${person.map.get("sister")}<br/>


</body>
</html>