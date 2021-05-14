const path = require('path');
const express = require('express');
const app = express();
const cors = require('cors');
const morgan = require('morgan');

app.use(cors());
app.use(morgan('combined'));
app.use(express.urlencoded({ extended: false }));
app.use(express.json());

app.get('/games', (req, res) => {
  const json = {   
    matches : [
        {
          id : 1,
          home :  {
              id: 1,
              name : "Hanwha",
              selected : false
            },
          away : {
            id: 2,
            name : "Doosan",
            selected : true
          }
        },
        {
            id : 2,
            home :  {
                id : 3,
                name : "Kia",
                selected : true
            },
            away : {
              id: 4,
              name : "Samsung",
              selected : true
            }
        },
        {
            id : 3,
            home : {
              id : 5,
              name : "Lotte",
              selected : true
            },
            away : {
              id : 6,
              name : "Lg",
              selected : true           
            }
        }
    ]
}   
  res.json(json);
});

app.post('/games/:gameId/teams/:teamId', (req, res) => {
  const successJson = {
    status: "SELECT_OK",
    message: "팀이 선택되었습니다."
  };

  const failJson = {
    statud: "SELECT_FAIL",
    message: "이미 선택된 팀입니다. 다른 팀을 골라 주세요."
  }

  res.json(req.params.teamId === 1 ? successJson : failJson);
});

app.get('/games/:id/start', (req, res) => {
  const json = {   
    "game_info" : {
        "id" : 1,
        "current_inning": 1,
        "frame" : "top"
    },
    "home" : {
      "name" : "hanwha",
      "mode" : "fielding",
      "score" : 0,
      "pitcher" : {
        "id" : 1, 
        "name" : "김광진" 
      },
      "batters" : [
        {
          "id" : 1,
          "name" : "김광진"
        },
        {
          "id" : 2,
          "name" : "크롱롱"
        },
        {
          "id" : 3,
          "name" : "제이세이"
        },
        {
          "id" : 4,
          "name" : "나이스"
        },
        {
          "id" : 5,
          "name" : "디코파기"
        },
        {
          "id" : 6,
          "name" : "봉프라이팬"
        },
        {
          "id" : 7,
          "name" : "햄버거지"
        },
        {
          "id" : 8,
          "name" : "치킨더가든"
        },
        {
          "id" : 9,
          "name" : "피자콜라면"
        }
      ]       
    },
    "away" : {
        "name" : "doosan",
        "mode" : "batting",
        "score" : 0,
        "pitcher" : {
          "id" : 1, 
          "name" : "김광진" 
        },
        "batters" : [
          {
            "id" : 10,
            "name" : "호눅스"
          },
          {
            "id" : 11,
            "name" : "크롱"
          },
          {
            "id" : 12,
            "name" : "제이케이"
          },
          {
            "id" : 13,
            "name" : "네이스"
          },
          {
            "id" : 14,
            "name" : "디코"
          },
          {
            "id" : 15,
            "name" : "봉프"
          },
          {
            "id" : 16,
            "name" : "햄버거"
          },
          {
            "id" : 17,
            "name" : "치킨"
          },
          {
            "id" : 18,
            "name" : "피자콜라"
          }
        ]       
    }
  };
  res.json(json);
});

app.listen(3030, () => { console.log('express server is running.'); });