  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
  <%@ page import="java.sql.*"%>
  
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta charset=UTF-8>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <script src="scripts.js"></script>
  <script src="https://unpkg.com/react/umd/react.development.js"></script>
  <script src="https://unpkg.com/react-dom/umd/react-dom.development.js"></script>
  <script src="https://unpkg.com/babel-standalone/babel.js"></script>
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
</head>
<body>
 <div class="container-fluid">

  <div id="app"></div>
  <script type="text/babel">
let DUZY = 123;
function MojKomponent({ title, content }) {
  return (
    <div>
 <dialog open>
      <h1>{title}</h1>
     <p>{content}</p>
</dialog>
    </div>
  );
}

function MojKomponent2({ title, content }) {

  return (
    <div>
      <dialog open>
     <h1>{title}</h1>
     <p>{content}</p>
      </dialog>
    </div>
  );
}


    ReactDOM.render(

<div> 

<MojKomponent2 content={DUZY} /> 
<MojKomponent title={ "tytul" } />
</div>,

      document.getElementById('app')
    );
  </script>


 <div class="input-group mb-3">

<form action="getOrders">
<button class="btn btn-info" type="submit">SHOW ORDERS</button>
</form>

<form action="getColors">
<button class="btn btn-danger" type="submit">SHOW COLORS</button>
</form>
</div>
<form action="addColors">
<input type="text" class="form-control" placeholder="Podaj nazwe koloru" id="nazwaKoloru" name="colorName">
<input type="text" class="form-control" placeholder="Podaj wartość R" id="r" name="r">
<input type="text" class="form-control" placeholder="Podaj wartość G" id="r" name="g">
<input type="text" class="form-control" placeholder="Podaj wartość B" id="r" name="b">
<button class="btn btn-danger" type="submit">ADD COLORS</button>
</form>

<form action="addCustomer">
<button class="btn btn-primary" type="submit">ADD CUSTOMER</button>
</form>


<form action="addOrder" name="Dodaj Zlecenie">
<div class="input-group mb-3">


<div class="input-group-append">
    <span class="input-group-text">Podaj nazwę klienta:</span></div>
   <input list="datalist_customer" id="nazwaKlienta1" class="form-control" placeholder="NAZWA KLIENTA" name="customerName">
  
  <div class="input-group mb-3">
 <div class="input-group-append">
    <span class="input-group-text">Podaj kolor 1:</span>
  </div><input list="datalist_colors" class="form-control" id="k1" placeholder="NAZWA KOLORU" name="colorName">
   <div class="input-group-append">
    <span class="input-group-text">Podaj r:</span>
  </div><input list="datalist_kolory" class="form-control" id="R1" placeholder="R" name="r">
   <div class="input-group-append">
    <span class="input-group-text">Podaj g:</span>
  </div><input list="datalist_kolory" class="form-control" id="G1" placeholder="G" name="g">
    <div class="input-group-append">
    <span class="input-group-text">Podaj b:</span>
  </div><input list="datalist_kolory" class="form-control" id="B1" placeholder="B" name="b"> 
  

  
  
  </div>
  </div>

<div class="input-group mb-3">

    <button class="btn btn-primary btn-block" type="submit">ADD ORDER TO DATABASE</button>

  </div>
  </form>

</div>
</body>
</html>