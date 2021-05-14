# Introduction 

# MineSweeper Projects
User API
Game API
React Web Application 

# Project Information Scope

1 - We ask that you complete the following challenge to evaluate your development skills. Please use the programming language and framework discussed during your interview to accomplish the following task.

PLEASE DO NOT FORK THE REPOSITORY. WE NEED A PUBLIC REPOSITORY FOR THE REVIEW. 

2 - The Game
Develop the classic game of [Minesweeper](https://en.wikipedia.org/wiki/Minesweeper_(video_game))

3 - Show your work

3.1.  Create a Public repository ( please dont make a pull request, clone the private repository and create a new plublic one on your profile)

3.2.  Commit each step of your process so we can follow your thought process.

4 - What to build

4.1. The following is a list of items (prioritized from most important to least important) we wish to see:
* Design and implement  a documented RESTful API for the game (think of a mobile app for your API)
* Implement an API client library for the API designed above. Ideally, in a different language, of your preference, to the one used for the API
* When a cell with no adjacent mines is revealed, all adjacent squares will be revealed (and repeat)
* Ability to 'flag' a cell with a question mark or red flag
* Detect when game is over
* Persistence
* Time tracking
* Ability to start a new game and preserve/resume the old ones
* Ability to select the game parameters: number of rows, columns, and mines
* Ability to support multiple users/accounts
 
5 - Deliverables we expect:
5.1 URL where the game can be accessed and played (use any platform of your preference: heroku.com, aws.amazon.com, etc)
5.2 Code in a public Github repo
5.3 README file with the decisions taken and important notes

6 - Time Spent
6.1 You need to fully complete the challenge. We suggest not spending more than 5 days total.  Please make commits as often as possible so we can see the time you spent and please do not make one commit.  We will evaluate the code and time spent.
6.2 What we want to see is how well you handle yourself given the time you spend on the problem, how you think, and how you prioritize when time is sufficient to solve everything.
6.3 Please email your solution as soon as you have completed the challenge or the time is up

# Getting Started Development Environment

1. Requirements 
- Install Docker

## 1. [Local Development with Docker Compose](https://devcenter.heroku.com/articles/local-development-with-docker-compose)
    
    $ docker-compose up -d --build
    $ open http://localhost:3000 /* access the web application with link */
	$ open http://localhost:8080 /* access the database manager adminer with link */
	$ open http://localhost:8081/swagger-ui.html /* access the Account Mananger API with link */
	$ open http://localhost:8082/swagger-ui.html /* access the game API with link */
	$ open http://localhost:8083 /* access the game API with link */

# Getting Started Production Environment
	
2. Container Orchestration Server and MicroServices 
- execute command "" on preferred CMD
- access the web application with link: https://bono-minesweeper-web.herokuapp.com
- access the database manager adminer with link: https://bono-minesweeper-adminer.herokuapp.com
- access the Account Mananger API with link: https://bono-minesweeper-Authentication-api.herokuapp.com 
- access the game API with link: https://bono-minesweeper-game-api.herokuapp.com
- access the monitoring server with link: https://bono-minesweeper-monitoring.herokuapp.com
- access the db server with link: https://bono-minesweeper-db.herokuapp.com

# Build and Test
1. Access the video by YouTube: 

# Reporting security issues and bugs
Security issues and bugs should be reported privately, via email, to developer by email richiebono@gmail.com. You should receive a response within maximum 24 hours.
