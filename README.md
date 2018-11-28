# Springbootmanytoone
OneToMany and ManyToOne mapping with lazy loading (default for onetomany). 

This example illustrates the relationship between Instructor entity and Course entity sharing OneToMany and ManyToOne relationship respectively. In this case it is bi-directional. We did not add cascading delete from instructor to course because existence of course and instructor are independent of each other. Also instructor_id is a foreign key in the course table.
So when deleting an instructor you must set instructor_id for the courses of the instructor to null otherwise SQL err : Foreign key constraint

Since its a bi-directional relationship both entities need to be a part of each other. We have courses field for Instructor and instructor field for Course. So when adding a course to an instructor also add the instructor to the course in a convienience method that takes care of both. If you dont initialize its going to take null for the field which can result in error. Therefore initiallize both tables with each others value.

Lazy fetch for courses by an instructor.
Until you call for instructors courses Hibernate wont make a query for the courses. Also you can only make the call for the courses
while the session is active otherwise we get LazyinitializationException. The proxy object dies after session ends.
It is performed to fasten the process of fetching all instructors. If the UI just shows the minor details of instructors there's no
need to fetch the list of courses each instructor provides. We fetch the courses for an instructor only if you want to view the details
of the instructor ie fetch only in demand.



