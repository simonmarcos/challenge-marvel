# Relational Database

### This is a relational database that stores information about users and characters. Each user can have many characters related to them.

# Tables

* User
    - id: The unique identifier of the user. Type is Long
    - first_name: The first name of the user. Type is String
    - last_name: The last name of the user. Type is String
    - email: The email of the user. Type is String
    - password: The password of each user is encrypted using BCryptPasswordEncoder for security purposes. Type is String


* Character

    - id: The unique identifier of the character. Type is Long
    - name: The name of the character. Type is String
    - description: The description of the character. Type is String
    - modified: The description of the character. Type is String
    - thumbnail: The thumbnail image of the character. Type is String
    - user_id: The user who owns the character. Type is Long