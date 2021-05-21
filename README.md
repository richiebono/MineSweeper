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

* Create a Public repository ( please dont make a pull request, clone the private repository and create a new plublic one on your profile)
* Commit each step of your process so we can follow your thought process.

4 - What to build

  The following is a list of items (prioritized from most important to least important) we wish to see:
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
* URL where the game can be accessed and played (use any platform of your preference: heroku.com, aws.amazon.com, etc)
* Code in a public Github repo
* README file with the decisions taken and important notes

6 - Time Spent
* You need to fully complete the challenge. We suggest not spending more than 5 days total.  Please make commits as often as possible so we can see the time you spent and please do not make one commit.  We will evaluate the code and time spent.
* What we want to see is how well you handle yourself given the time you spend on the problem, how you think, and how you prioritize when time is sufficient to solve everything.
* Please email your solution as soon as you have completed the challenge or the time is up

# Getting Started Development Environment

1. Requirements 
- Install Docker:<br>
  [For macOS](https://docs.docker.com/docker-for-mac/install/)<br>
  [For Linux systems](https://docs.docker.com/engine/install/ubuntu/)<br>
  [For Windows systems](https://docs.docker.com/docker-for-windows/install/)

- Install Docker-Machine

	[For macOS](https://docs.docker.com/docker-for-mac/install/)<br>
	[For Linux systems](https://docs.docker.com/engine/install/ubuntu/)<br>
  
	[For Windows](https://github.com/docker/machine/releases/download/v0.16.2/docker-machine-Windows-x86_64.exe)

## 1. Local Development with Docker Compose
    
    $ docker-compose up -d --build
    $ open http://localhost:3000 /* access the web application with link */
	$ open http://localhost:8080 /* access the database manager adminer with link */
	$ open http://localhost:8081/swagger-ui.html /* access the Account Mananger API with link */
	$ open http://localhost:8082/swagger-ui.html /* access the game API with link */
	$ open http://localhost:8083 /* access the game API with link */

# Getting Started Production Environment
	
## 1. Step 1: Download the Amazon ECS CLI
  
 1.1. For macOS:

	$ sudo curl -Lo /usr/local/bin/ecs-cli https://amazon-ecs-cli.s3.amazonaws.com/ecs-cli-darwin-amd64-latest

 1.2. For Linux systems:
	
	$ sudo curl -Lo /usr/local/bin/ecs-cli https://amazon-ecs-cli.s3.amazonaws.com/ecs-cli-linux-amd64-latest
	
 1.3 For Windows systems:

  Open Windows PowerShell with admin privileges and run the following commands:	
 
	$ New-Item -Path 'C:\Program Files\Amazon\ECSCLI' -ItemType Directory
	$ Invoke-WebRequest -OutFile 'C:\Program Files\Amazon\ECSCLI\ecs-cli.exe' https://amazon-ecs-cli.s3.amazonaws.com/ecs-cli-windows-amd64-latest.exe
	
## 2. Step 2: Verify the Amazon ECS CLI using PGP signatures

 The Amazon ECS CLI executables are cryptographically signed using PGP signatures. The PGP signatures can be used to verify the validity of the Amazon ECS CLI executable. Use the following steps to verify the signatures using the GnuPG tool.
  <br>
  Download and install GnuPG. For more information, see the [GnuPG website](https://www.gnupg.org/).

  For macOS, we recommend using Homebrew. Install Homebrew using the instructions from their website. For more information, see [Homebrew](https://brew.sh/). After Homebrew is installed, use the following command from your macOS terminal.

	$ brew install gnupg
	
  For Linux systems, install gpg using the package manager on your flavor of Linux.

  For Windows systems, download and use the Windows simple installer from the GnuPG website. For more information, see [GnuPG Download](https://www.gnupg.org/download/index.html).

 <br>
 2.2. Retrieve the Amazon ECS PGP public key. You can use a command to do this or manually create the key and then import it.
  <br>
  a. Retrieve the key with the following command.
	
	$ gpg --keyserver hkp://keys.gnupg.net --recv BCE9D9A42D51784F

  b. Import the Amazon ECS PGP public key with the following command.
	
	$ gpg --import signature.key
	
 2.3. Download the Amazon ECS CLI signatures. The signatures are ASCII detached PGP signatures stored in files with the extension .asc. The signatures file has the same name as its corresponding executable, with .asc appended.

  For macOS systems:
  
	$ curl -Lo ecs-cli.asc https://amazon-ecs-cli.s3.amazonaws.com/ecs-cli-darwin-amd64-latest.asc

  For Linux systems:
  
	$ curl -Lo ecs-cli.asc https://amazon-ecs-cli.s3.amazonaws.com/ecs-cli-linux-amd64-latest.asc
	
  For Windows systems:
  
	$ Invoke-WebRequest -OutFile ecs-cli.asc https://amazon-ecs-cli.s3.amazonaws.com/ecs-cli-windows-amd64-latest.exe.asc

 2.4. Verify the signature.

  For macOS and Linux systems:
	
	$ gpg --verify ecs-cli.asc /usr/local/bin/ecs-cli

  For Windows systems:
	
	$ gpg --verify ecs-cli.asc 'C:\Program Files\Amazon\ECSCLI\ecs-cli.exe'
	
  Expected output:
	
	$
		gpg: Signature made Tue Apr  3 13:29:30 2018 PDT
		gpg:                using RSA key DE3CBD61ADAF8B8E
		gpg: Good signature from "Amazon ECS <ecs-security@amazon.com>" [unknown]
		gpg: WARNING: This key is not certified with a trusted signature!
		gpg:          There is no indication that the signature belongs to the owner.
		Primary key fingerprint: F34C 3DDA E729 26B0 79BE  AEC6 BCE9 D9A4 2D51 784F
			 Subkey fingerprint: EB3D F841 E2C9 212A 2BD4  2232 DE3C BD61 ADAF 8B8E


## 3. Step 3: Apply Execute Permissions to the Binary

  Apply execute permissions to the binary.

  For macOS and Linux systems:
	
	$ sudo chmod +x /usr/local/bin/ecs-cli

  For Windows systems:
  <br>
  Edit the environment variables and add C:\Program Files\Amazon\ECSCLI to the PATH variable field, separated from existing entries by using a semicolon. For example:
	
	$ setx path "%path%;C:\Program Files\Amazon\ECSCLI"
	
  Restart PowerShell (or the command prompt) so the changes go into effect.

  Note
  Once the PATH variable is set, the Amazon ECS CLI can be used from either Windows PowerShell or the command prompt.

 ## 4. Step 4: Complete the Installation
  
  Verify that the CLI is working properly.
	
	$ ecs-cli --version
	
  Proceed to Configuring the Amazon ECS CLI.

## 5. Configure ecs-cli

  5.1. Prerequisite

  AWS CLI v2 must be installed.
  *You need to have an AWS_ACCESS_KEY_ID / AWS_SECRET_ACCESS_KEY with administrative privileges
	 
  To create your AWS_ACCESS_KEY_ID you can read this [documentation](https://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_access-keys.html#Using_CreateAccessKey)
   
  The following script configure an ECS-profile called tutorial for a cluster named minesweeper-cluster on the us-west-2 region with a default launch type based on EC2 instances:
	
 EC2 (Deploy and manage your own cluster of EC2 instances for running the containers)
 AWS Fargate (Run containers directly, without any EC2 instances)
 If we want to connect to the ec2 instances with ssh we need to have a key pair

 👉 Creation of a key pair called minesweeper-cluster :
 
	$ aws ec2 create-key-pair --key-name minesweeper-cluster --query 'KeyMaterial' --output text > minesweeper-cluster.pem --region us-west-1
	
👉 List minesweeper-cluster key-pairs:	
	
	$ aws ec2 describe-key-pairs --region us-west-1

👉 If you wish to delete minesweeper-cluster key-pairs:	

	$ aws ec2 delete-key-pair --key-name minesweeper-cluster
  
👉 Configure profile:	  
  
	$ ecs-cli configure --cluster minesweeper-cluster --default-launch-type EC2 --config-name minesweeper-cluster --region us-west-1	
	$ ecs-cli configure profile --access-key <your access key> --secret-key <your secret key>  --profile-name minesweeper-cluster-profile
	
## 6. Creation of an ECS-Cluster 🚀
	
 We will create an ECS-Cluster based on ec2 instance.
 ECS allows 3 launch types EC2 and FARGATE

 reation of the Cluster minesweeper-cluster with 3 ec2-instances t2.medium  

Create ECS Context:
  
	$ docker context create ecs minesweeper-cluster
	$ docker context ls
	$ docker context use minesweeper-cluster		
	
 This stack can best tested locally
	
	$ docker context use default
	$ docker-compose up -d --build
	$ docker-compose down
	$ docker context use minesweeper-cluster
	
 We can now deploy this stack on AWS ECS:
	
	$ ecs-cli up --keypair minesweeper-cluster --capability-iam --size 3 --instance-type t3.medium --cluster-config minesweeper-cluster --ecs-profile minesweeper-cluster-profile --capability-iam
	$ ecs-cli compose up --create-log-groups --cluster-config minesweeper-cluster --ecs-profile minesweeper-cluster-profile
	
 To verify that the service is running we can use these commands:
	
	$ aws ecs describe-clusters --cluster minesweeper-cluster
	$ ecs-cli ps --cluster-config minesweeper-cluster --ecs-profile minesweeper-cluster-profile
	
 If you wish to delete cluster:
	
	$ ecs-cli compose service rm --cluster-config minesweeper-cluster --ecs-profile minesweeper-cluster-profile
	$ ecs-cli down --force --cluster minesweeper-cluster --region eu-west-1
	
# Reporting security issues and bugs
Security issues and bugs should be reported privately, via email, to developer by email richiebono@gmail.com. You should receive a response within maximum 24 hours.
