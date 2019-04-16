<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Currency Exchange List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Id</th>
        <th>Full Name</th>
        <th>CCY</th>
        <th>Base_CCY</th>
        <th>Buy</th>
        <th>Sale</th>
        <th>Date</th>
        <th>Amount</th>
        <th>Status</th>
    </tr>
    <c:forEach var="exch" items="${list}">
        <tr>
            <td>${exch.id}</td>
            <td>${exch.fullName}</td>
            <td>${exch.ccy}</td>
            <td>${exch.base_ccy}</td>
            <td>${exch.buy}</td>
            <td>${exch.sale}</td>
            <td>${exch.date}</td>
            <td>${exch.amount}</td>
            <td>${exch.status}</td>
        </tr>
    </c:forEach>
</table>
<br/>
