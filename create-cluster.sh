#!/bin/bash
KEY_PAIR=minesweeper-cluster
	ecs-cli up \
	  --keypair $KEY_PAIR  \
	  --capability-iam \
	  --size 6 \
	  --instance-type t3.medium \
	  --tags project=minesweeper-cluster,owner=richiebono \
	  --cluster-config minesweeper \
	  --ecs-profile minesweeper