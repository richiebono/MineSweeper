FROM node:14.1-alpine AS builder

WORKDIR /opt/web
COPY ./MineSweeper.Web.React/package.json ./
RUN npm install

ENV PATH="./node_modules/.bin:$PATH"

COPY ./MineSweeper.Web.React ./
RUN npm run build

CMD ["npm", "start"]