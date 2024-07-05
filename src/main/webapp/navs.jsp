
<%@page import="entity.Opcion"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="entity.Usuario" %>

<%
    // Verifica si la página está siendo incluida
    Boolean includeNavs = (Boolean) session.getAttribute("includeNavs");
    if (includeNavs == null || !includeNavs) {
        // Redirige a la página principal si no está siendo incluida
        response.sendRedirect("home.jsp");
        return;
    }
%>

<jsp:include page="validacion.jsp"/>

<div class="container">

    <!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!----======== CSS ======== -->
    <link rel="stylesheet" href="css/sidepanel.css">

    <!----===== Boxicons CSS ===== -->
    <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>

</head>
<body>
    <nav class="sidebar close">
        <header>
            <div class="image-text">
                <span class="image">
                    <img src="img/img.png" alt="">
                </span>

                <div class="text logo-text">
                    <span class="name">PowerPlant</span>
                </div>
            </div>

            <i class='bx bx-chevron-right toggle'></i>
        </header>

        <div class="menu-bar">
            <div class="menu">

                <li class="search-box">
                    <i class='bx bx-search icon'></i>
                    <input type="text" placeholder="Buscar...">
                </li>

                <ul class="menu-links">
                    <%
                    ArrayList<Opcion> listMain = (ArrayList<Opcion>) session.getAttribute("Objmenus");
                    if (listMain != null) {
                        for (Opcion op : listMain) {
                    %>
                    <li  class="nav-link">
                        <a href="<%= op.getRuta()%>">
                            <span class="text nav-text"> <%= op.getNombre()%></span>

                        </a>
                    </li>
                   <%
                        }
                    }
                   %>

                </ul>
            </div>

            <div class="bottom-content">
                <li class="">
                    <a href="logout">
                        <i class='bx bx-log-out icon' ></i>
                        <span class="text nav-text">Cerrar sesion</span>
                    </a>
                </li>

                <li class="mode">
                    <div class="sun-moon">
                        <i class='bx bx-moon icon moon'></i>
                        <i class='bx bx-sun icon sun'></i>
                    </div>
                    <span class="mode-text text">Modo oscuro</span>

                    <div class="toggle-switch">
                        <span class="switch"></span>
                    </div>
                </li>

            </div>
        </div>

    </nav>
    <section class="home">
        <div class="top-home">
        <div class="text" style="font-size: 20px;text-align: right;align-content: center;padding: 0px !important;">${sessionScope.Objusuario.nombreCompleto}</div>
            <img class="avatar" src="${sessionScope.Objusuario.image}">

        </div>
        </section>

    <script>
        const body = document.querySelector('body'),
      sidebar = body.querySelector('nav'),
      toggle = body.querySelector(".toggle"),
      searchBtn = body.querySelector(".search-box"),
      modeSwitch = body.querySelector(".toggle-switch"),
      modeText = body.querySelector(".mode-text");


toggle.addEventListener("click" , () =>{
    sidebar.classList.toggle("close");
})

searchBtn.addEventListener("click" , () =>{
    sidebar.classList.remove("close");
})

modeSwitch.addEventListener("click" , () =>{
    body.classList.toggle("dark");

    if(body.classList.contains("dark")){
        modeText.innerText = "Light mode";
    }else{
        modeText.innerText = "Dark mode";

    }
});
    </script>

</body>
</html>


</div>