<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Exchange</title>
    <link rel="stylesheet" type="text/css" href="css/admin_style.css">
    <style>
        body {
            height: 200px;
            background: linear-gradient(45deg, #EECFBA, #C5DDE8);
        }
    </style>
</head>
<body>
<div id='kurs-com-ua-informer-main-ukraine-300x130-blue-container'>
    <a href="//old.kurs.com.ua/informer"
       id="kurs-com-ua-informer-main-ukraine-300x130-blue"
       title="Курс валют информер Украина" rel="nofollow"
       target="_blank">Информер курса валют</a></div>
<script type='text/javascript'>
    (function () {
        var iframe = '<ifr' + 'ame src="//old.kurs.com.ua/informer/inf2?color=blue" width="300" height="130" ' +
            'frameborder="0" vspace="0" scrolling="no" hspace="0"></ifr' + 'ame>';
        var container = document.getElementById('kurs-com-ua-informer-main-ukraine-300x130-blue');
        container.parentNode.innerHTML = iframe;
    })();
</script>
<noscript><img src='//old.kurs.com.ua/static/images/informer/kurs.png' width='52' height='26'
               alt='kurs.com.ua: курс валют в Украине!' title='Курс валют' border='0'/></noscript>

<form class="form-3" action='userMenu.html'>
    <p class="clearfix">
        <input type="submit" name="submit" value="User" />
    </p>
</form>
<form class="form-3" action='adminLogin.html'>
    <p class="clearfix">
        <input type="submit" name="submit" value="Admin" />
    </p>
</form>
</body>
</html>
