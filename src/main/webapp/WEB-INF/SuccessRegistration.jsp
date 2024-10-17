<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form Submission Successful</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        h2 {
            color: #333;
        }
        .detail {
            margin: 10px 0;
        }
        .label {
            font-weight: bold;
        }
        .success-message {
            color: green;
            font-size: 1.2em;
            margin-bottom: 20px;
        }
        .back-link {
            margin-top: 20px;
            display: inline-block;
            text-decoration: none;
            color: #007BFF;
        }
        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Submission Successful</h2>
        <p class="success-message">Your form has been successfully submitted. Here are the details:</p>
        
        <div class="detail">
            <span class="label">First Name:</span> ${firstName}
        </div>
        <div class="detail">
            <span class="label">Family Name:</span> ${familyName}
        </div>
        <div class="detail">
            <span class="label">Email:</span> ${email}
        </div>

        <!-- Lien pour retourner au formulaire -->
        <a href="<%= request.getContextPath() %>/ServletRegistration" class="back-link">Return to Registration Form</a>
    </div>
</body>
</html>
