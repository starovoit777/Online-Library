    <!DOCTYPE html>
        <html>
        <head>
        <style>
        body {margin:0;}

        .navbar {
        overflow: hidden;
        background-color: #333;
        position: fixed;
        top: 0;
        width: 100%;
        }

        .navbar a {
        float: left;
        display: block;
        color: #f2f2f2;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
        font-size: 17px;
        }

        .main {
        padding: 16px;
        margin-top: 30px;
        height: 1500px; /* Used in this example to enable scrolling */
        }
        </style>
        </head>


        <body>

        <div class="navbar">
        <a href="#home">Home</a>
        <a href="#autors">Autors</a>
        <a href="#books">Books</a>
        <a href="#serth">Serth</a>
        <a href="login">Login</a>
        <a href="users">User list</a>
        </div>

        <div class="main">
        <h1>Fixed Top Menu</h1>
        <h2>Scroll this page to see the effect</h2>
        <h2>The navigation bar will stay at the top of the page while scrolling</h2>
        <p>Some text some text some text some text..</p>

        <a href="login">login</a>|
        <a href="logout">logout</a>|
        <a href="profile">profile</a>

        </div>


        </body>
        </html>