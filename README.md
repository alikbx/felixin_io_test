# felixin_io_test


In spring boot and embed Apache Derby DB

1- Define user management, Authentication, and Authorization in spring security by
fields (user_id, name, role)

2- create a table for numbers List (number_id, number)

3- create endpoint /admin/generate and generate 1000 random numbers between
3000000-6000000. This endpoint must be accessible just by users by role “admin,” and
whenever runs must generate the new number and remove old numbers from the table

4- create endpoint /user/check-number and get one number by post
First, check this number must be between 3000000-6000000 and else throw an
appropriate exception.
Second, if the number is in range, then find ten numbers from the database. This is
smaller and nearest to this number and finds ten numbers from the database that are
bigger and nearest to this number. It means this number must be in the middle of these
20 numbers.
