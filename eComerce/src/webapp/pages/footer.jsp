<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

</div>
<div class="col-md-4">

</div>
</div>


<footer>

</footer>
</body>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/resources/js/jquery-2.2.2.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/resources/js/bootstrap.js"></script>

<script>
    $(document).ready(
            $(function(){
                $('#add-to-cart').submit(function(e){
                    var $form = $(this);
                    $.ajax({
                        type: $form.attr('method'),
                        url: $form.attr('action'),
                        data: $form.serialize(),
                        dataType: 'json',
                        success: function(data){
                            var content = "<li><a href='/cart'>Перейти в корзину</a></li>" +
                                    "<table class='table'><tr><th>ID</th><th>Наименование товара</th>" +
                                    "<th>Цена</th></tr>";
                            var sum = 0;
                            var badge = 0
                            $.each( data, function( i, l ){
                                sum += l.price;
                                badge = i + 1;
                                content += "<tr><td>" + l.id + "</td>" +
                                        "<td>" + l.name + "</td>" +
                                        "<td>" + l.price + "</td></tr>"
                            })
                            content += "<tr><td></td><td><strong>Сумма заказа: </strong></td>" +
                                            "<td>" + sum + "</td></tr>";
                            $("#cart-dropdown").html(content);
                            $("#cart-badge").html(badge);
                        }
                    }).done(function() {
                        console.log('success');
                    }).fail(function() {
                        console.log('fail');
                    });
                    e.preventDefault();
                });
            })


    );
</script>

</html>