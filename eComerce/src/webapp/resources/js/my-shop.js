/**
 * Created by jdev on 03.04.2016.
 */

$(document).ready(
    $(function () {

        $('#from-cart').submit(function (e) {
            var $form = $(this);
            $.ajax({
                type: 'POST',
                url: '/cart/checkout',
                data: '',
                dataType: 'json',
                success: function (data) {
                    var content = "<div class='alert alert-success' role='alert'>" + data + "</div>";
                    $("#msg").html(content);
                }
            }).done(function () {
                console.log('success');
            }).fail(function () {
                console.log('fail');
            });
            e.preventDefault();
        });

        $('#add-to-cart').submit(function (e) {
            var $form = $(this);
            $.ajax({
                type: $form.attr('method'),
                url: $form.attr('action'),
                data: $form.serialize(),
                dataType: 'json',
                success: function (data) {
                    var content = "<li><a href='/cart'>Перейти в корзину</a></li>" +
                        "<table class='table'><tr><th>ID</th><th>Наименование товара</th>" +
                        "<th>Цена</th></tr>";
                    var sum = 0;
                    var badge = 0
                    $.each(data, function (i, l) {
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
            }).done(function () {
                console.log('success');
            }).fail(function () {
                console.log('fail');
            });
            e.preventDefault();
        });
    })
);
