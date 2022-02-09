# Restaurant Crib Sheet
A daily checklist for the manager on duty to view employees scheduled for the entire day.  One last check to ensure coverage is adequate for the day, employees are on time, working in the appropriately designated role, and view labor costs for the day.


![](../../../../Documents/Funny-Restaurant-memes-3.jpeg)


### Inspiration :exploding_head:
______
As a former restaurant manager handwritten lists become all to familiar.  It is helpful to have documents easily accessible to stay organized and ready for the day ahead.  But things change very quickly and sometimes without proper notice.  Having a tool that is readable yet uncomplicated to update would be very beneficial to the manager leading a shift.


## Technical Information 
______
*Tools used*

-- Java
-- IntelliJ
-- Spring boot
-- Maven
-- Postman
-- PGAdmin --

### Links
###### W3Schools
###### GitHub
###### Youtube
###### mvnrepository
###### geeksforgeeks
###### MDN Web Docs
##### https://dzone.com/articles/march-madness-and-the-random-generator


_______

## User Story (Original Idea)
- As a user, I would like to login
    - Email and password to login
    - JWT Token
    - Token last 1 hour  
    - Authentication Header
    - Bearer key
- As a user, I would like create my selections for each winner of the 8 games played
  - Round of 16 has 8 games
  - Be able to view matchup
  - Picks based on user personal interests
  - Game_id 1 winner
  - Game_id 2 winner
  - As a user, I would like to view the team seeds
  - Team seeds in game entity
  - As a user, I would like to view who the home team is
  - Home team in game entity
- As a user, I would like to view who the away team is
  - Away team in game entity
- As a user, I would like to view the winners for each game
  - Result entity to hold winners
  - Game_id relationship
  - Team_id relationship
  - As a user, I would like to view my number of wins vs other user’s selections
- User_profile attachment to Results entity
  - Access of another profile’s results by user name


## User Story (Actual)
- As a user, I would like to login
  - User email and password to safely login
  - JWT Token used for authentication
- As a user, I would like to create a daily schedule
  - One schedule per day of the week
  - Can be updated, deleted, posted, and read
  - Not be able to create more than one schedule for a date that exists already
- As a user, I would like to add employees to the schedule
  - Have access to an employee database with:
    - Employee id
    - Employee name
    - Employee wage
    - Employee position
    - Employee availability
  - Be able to update, create, delete, and read employee data


## ERD Diagram(Original and Actual)
______
###Original
<img width="1342" alt="Screen Shot 2022-01-28 at 5 50 50 PM" src="https://user-images.githubusercontent.com/94800802/152569632-f88c4340-3d48-4296-975b-7724cc797433.png">

###Implemented
![Screen Shot 2022-02-04 at 11 41 43 AM](https://user-images.githubusercontent.com/94800802/152569667-c8731798-3ad8-467e-be6f-64e5e6b2f4d1.png)

_____

# Challenges
1. Starting with a project that was way beyond my ability and not being realistic with the time it would take to complete.
2. Truly comprehending entity relationships and how a table gets built out.
3. Starting small and constantly testing code
4. Linking postman with my code
5. Logic in my service class for implementing CRUD in postman

# Silver lining
1. Gained a better understanding of Java
2. Learned a great deal about the flow of product design
3. Got close to finishing after wasting several days on a concept that was too big
4. Better KISS practices
5. Better committing practices

# Future Functionality
1. Admin level who has full functionality
2. User level who can read and update scheduled employees
3. Expected sales vs labor cost report
4. In time and out time available to view
5. Overtime warnings



