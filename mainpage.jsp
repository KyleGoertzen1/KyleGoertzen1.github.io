<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://www.paypalobjects.com/api/checkout.js"></script>
        <script src="https://js.braintreegateway.com/web/3.11.0/js/client.min.js"></script>
        <script src="https://js.braintreegateway.com/web/3.11.0/js/paypal-checkout.min.js"></script>

        <!--
        
        -->
        <style>
            a:link {
                background-color: yellow;
                padding: 14px 25px;
            }

            a:visited {
                background-color: cyan;
                padding: 14px 25px;
            }

            a:hover {
                background-color: lightgreen;
            }

            a:active {
                background-color: hotpink;
            }

            .home {
                margin-top: 0px;
                margin-left: 200px;
                font-size: 50px
            }

            .info {
                margin-top: -58px;
                margin-left: 400px;
                font-size: 50px
            }

            .contact {
                margin-top: -59px;
                margin-left: 820px;
                font-size: 50px
            }

            .image1 {
                margin-top: 200px;
                margin-left: 0px;
            }

            .image2 {
                margin-top: -303px;
                margin-left: 267px;
            }

            .pay1 {
                margin-top: 0px;
                margin-left: 0px;
            }

            .pay2 {
                margin-top: -30px;
                margin-left: 267px;
            }

            body {
                background-color: white;
            }

            h1 {
                color: green;
                text-align: center;
            }

            .username {
                margin-left: 540px;
            }

            .password {
                margin-left: 543px;
            }

            .adduser {
                margin-left: 542px;
            }

            .addheader {
                text-align: center;
            }

            .topic {
                margin-left: 567px;
            }

            .information {
                margin-left: 527px;
            }

            .addpost {
                margin-left: 543px;
            }

            .addtopic {
                margin-top: 500px;
                text-align: center;
            }

            .user {
                margin-top: -650px;
                margin-left: 600px;
            }

            .welcome {
                text-align: center;
            }

            .post {
                margin-left: 20px;
            }
        </style>
        <!-- <link rel="stylesheet" type="text/css" href="style.css"> -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body>

        <!-- <div id="paypal-button-container"></div>

        <script>

            // Render the PayPal button

            paypal.Button.render({

                // Pass in the Braintree SDK

                braintree: braintree,

                // Pass in your Braintree authorization key

                client: {
                    sandbox: paypal.request.get('/demo/checkout/api/braintree/client-token/'),
                    production: '<insert production auth key>'
                },

                // Set your environment

                env: 'sandbox', // sandbox | production

                // Wait for the PayPal button to be clicked

                payment: function(data, actions) {

                    // Make a call to create the payment

                    return actions.payment.create({
                        payment: {
                            transactions: [
                                {
                                    amount: { total: '0.01', currency: 'USD' }
                                }
                            ]
                        }
                    });
                },

                // Wait for the payment to be authorized by the customer

                onAuthorize: function(data, actions) {

                    // Call your server with data.nonce to finalize the payment

                    console.log('Braintree nonce:', data.nonce);

                    // Get the payment and buyer details

                    return actions.payment.get().then(function(payment) {
                        console.log('Payment details:', payment);
                    });
                }

            }, '#paypal-button-container');

        </script> -->

        <a href="login?logout">Logout</a>
        <!--        <div class="welcome">-->
        Welcome, ${username}
        <!--        </div>-->

        <br/>
        ${message}
        <br/>

        <h1>Moon Goddess Art & Jewelry</h1>

        <div class="home">
            <a href="users">Home</a>
        </div>

        <div class="info">
            <a href="information">Artist Information</a>
        </div>

        <div class="contact">
            <a href="contact">Contact Cindy</a>
        </div>

        <br/>
        <h2>Post in the forum at the bottom of this page.
            <br/>
            Regarding comments questions and concerns text (250) 430-2171.
            <br/>
            Add to your shopping cart using the PayPal® buttons below the merchandise in the following photographs.
        </h2>

        <div class="image1">
            <img src="001.jpg" alt="Forest Painting" weight="300" height="300">
        </div>

        <div class="image2">
            <img src="002.jpg" alt="Jewelry" weight="300" height="300">
        </div>

        <div class="pay1">
            <form target="paypal" action="https://www.paypal.com/cgi-bin/webscr" method="post">
                <input type="hidden" name="cmd" value="_s-xclick">
                <input type="hidden" name="hosted_button_id" value="VXP34ME2G5AVE">
                <input type="image" src="https://www.paypalobjects.com/en_US/i/btn/btn_cart_LG.gif" border="0" name="submit" alt="PayPal - The safer, easier way to pay online!">
                <img alt="" border="0" src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" width="1" height="1">
            </form>
        </div>

        <div class="pay2">
            <form target="paypal" action="https://www.paypal.com/cgi-bin/webscr" method="post">
                <input type="hidden" name="cmd" value="_s-xclick">
                <input type="hidden" name="hosted_button_id" value="86QPRAZTARHC8">
                <input type="image" src="https://www.paypalobjects.com/en_US/i/btn/btn_cart_LG.gif" border="0" name="submit" alt="PayPal - The safer, easier way to pay online!">
                <img alt="" border="0" src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" width="1" height="1">
            </form>
        </div>

        <c:if test="${isAdmin}">
            <div class ="addheader">
                <c:if test="${isAdmin}">
                    <h3>Add User</h3>
                </c:if>
            </div>
            <c:if test="${isAdmin}">
                <form action="users" method="POST">
                    <div class="username">
                        Username: <input type="text" name="username"><br/>
                    </div>
                    <div class="password">
                        Password: <input type="password" name="password"><br/>
                    </div>
                    <div class="adduser">
                        <input type="submit" value="Add User">

                    </div>
                </form>
            </c:if>
        </c:if>
        <br/>
        <div class="thread">
            <div class ="addtopic">
                <h3>Add Post</h3>
            </div>
            <form action="users" method="POST">
                <input type="hidden" name="creator" value="${username}">
                <div class="topic">
                    Topic: <input type="text" name="topic"><br/>
                </div>
                <div class="information">
                    Information: <input type="text" name="information"><br/>
                </div>
                <div class="addpost">
                    <input type="submit" value="Add Post">
                </div>
            </form>
        </div>

        <c:if test="${isAdmin}">
            <div class = "user">
                <h3>List of Users</h3>
                <table border="1">
                    <tr>
                        <th>Username</th>
                            <c:if test="${isAdmin}">
                            <th>Delete</th>
                            </c:if>
                    </tr>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td> <c:out value="${user.username}"></c:out> </td>
                            <c:if test="${isAdmin}">
                                <td> 
                                    <form action="users" method="POST">
                                        <input type="submit" value="Delete">
                                        <input type="hidden" name="action" value="deleteUser">
                                        <input type="hidden" name="selectedUserDelete" value="${user.username}">
                                    </form>
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </c:if>
        <br>

        <div class="post">
            <h2>List of Posts</h2>
            <table border="1">
                <tr>
                    <th>Name</th>
                    <th>Topic</th>
                    <th>Post</th>
                        <c:if test="${isAdmin}">
                        <th>Delete</th>
                        </c:if>
                </tr>
                <c:forEach items="${posts}" var="post">
                    <tr>
                        <td> <c:out value="${post.name}"> </c:out> </td>
                        <td> <c:out value="${post.topic}"> </c:out> </td>
                        <td> <c:out value="${post.information}"> </c:out> </td>
                        <c:if test="${isAdmin}">
                            <td>
                                <form action="users" method="POST">
                                    <input type="submit" value="Delete">
                                    <input type="hidden" name="action" value="deletePost">
                                    <input type="hidden" name="selectedPostDelete" value="${post.topic}">
                                </form>
                            </td>
    <!--                            <td><a href="?topic=${post.topic}&delete">Delete</a></td> -->
                        </c:if>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
