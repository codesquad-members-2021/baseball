(this.webpackJsonpbaseball=this.webpackJsonpbaseball||[]).push([[0],{39:function(e,n,t){},50:function(e,n,t){"use strict";t.r(n);var r,a,i,c,o,s,l,d,m=t(1),u=t.n(m),b=t(29),h=t.n(b),f=(t(39),t(40),t(2)),j=t(3),p=t(8),v=t.n(p),g=t(12),O=t(7),x=function(e,n){var t=arguments.length>2&&void 0!==arguments[2]?arguments[2]:"",r=Object(m.useState)(null),a=Object(O.a)(r,2),i=a[0],c=a[1],o=function(){var e=Object(g.a)(v.a.mark((function e(n,t,r){var a,i,o,s,l,d;return v.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:if(e.prev=0,"get"!==t){e.next=11;break}return e.next=4,fetch(n);case 4:return a=e.sent,e.next=7,a.json();case 7:i=e.sent,c(i),e.next=31;break;case 11:if("post"!==t){e.next=22;break}return console.log("post",r),e.next=15,fetch(n,{method:"post",headers:{"Content-Type":"application/json"},body:JSON.stringify(r)});case 15:return o=e.sent,e.next=18,o.json();case 18:s=e.sent,console.log(o,s),e.next=31;break;case 22:if("put"!==t){e.next=31;break}return console.log("put",r),e.next=26,fetch(n,{method:"put",headers:{"Content-Type":"application/json"},body:JSON.stringify(r)});case 26:return l=e.sent,e.next=29,l.json();case 29:d=e.sent,console.log(l,d);case 31:e.next=36;break;case 33:e.prev=33,e.t0=e.catch(0),console.log(e.t0);case 36:case"end":return e.stop()}}),e,null,[[0,33]])})));return function(n,t,r){return e.apply(this,arguments)}}();return Object(m.useEffect)((function(){o(e,n,t)}),[]),{data:i}},y=t(16),w=t(0),k=j.a.div(r||(r=Object(f.a)(["\n  margin: 0 auto;\n  margin-bottom: 1.5rem;\n  padding: 1rem 0;\n  border-radius: 1rem;\n  background-color: rgba(210, 210, 210, 0.95);\n  .title {\n    color: #ff4545;\n    text-align: center;\n    font-size: 1.5rem;\n    font-weight: 600;\n  }\n  .teams {\n    display: grid;\n    grid-template-columns: 1fr 6rem 1fr;\n    text-align: center;\n    align-items: center;\n    padding: 1rem 0;\n    &-name {\n      font-size: 2rem;\n      font-weight: 600;\n      cursor: pointer;\n      &:hover {\n        color: #ff4545;\n      }\n    }\n    &-vs {\n      padding-bottom: 0.5rem;\n      font-size: 2.5rem;\n      font-weight: 600;\n      color: #777;\n    }\n    a {\n      text-decoration: none;\n      color: #000;\n    }\n    a:visited {\n      color: #000;\n    }\n  }\n"]))),N=function(e){var n=e.home,t=e.away,r=e.id,a=e.idx,i="games/".concat(r),c=function(e){localStorage.setItem("select",e.target.textContent),localStorage.setItem("teams",JSON.stringify({home:n,away:t}))};return Object(w.jsxs)(k,{children:[Object(w.jsxs)("div",{className:"title",children:["GAME ",a+1]}),Object(w.jsxs)("div",{className:"teams",children:[Object(w.jsx)(y.b,{to:i,onClick:c,children:Object(w.jsx)("div",{className:"teams-name",children:n})}),Object(w.jsx)("div",{className:"teams-vs",children:"vs"}),Object(w.jsx)(y.b,{to:i,onClick:c,children:Object(w.jsx)("div",{className:"teams-name",children:t})})]})]})},T=j.a.div(a||(a=Object(f.a)(["\n  padding: 0 15vw;\n  margin-top: 2.5rem;\n"]))),z=j.a.div(i||(i=Object(f.a)(["\n  margin-bottom: 5rem;\n  font-size: 3rem;\n  font-weight: 600;\n  color: #fff;\n  text-align: center;\n"]))),S=j.a.div(c||(c=Object(f.a)(["\n  margin-bottom: 2rem;\n  font-size: 2rem;\n  color: #fff;\n  text-align: center;\n"]))),_=j.a.div(o||(o=Object(f.a)(["\n  max-width: 50rem;\n  margin: 0 auto;\n  padding-left: 1.0625rem;\n  max-height: 31rem;\n  overflow-y: scroll;\n  mask-image: linear-gradient(to top, transparent, black),\n    linear-gradient(to left, transparent 17px, black 17px);\n  mask-size: 100% 20000px;\n  mask-position: left bottom;\n  transition: mask-position 0.3s;\n  &:hover {\n    mask-position: left top;\n  }\n  &::-webkit-scrollbar {\n    width: 0.875rem;\n  }\n  &::-webkit-scrollbar-thumb {\n    background-color: #999;\n    border-radius: 0.375rem;\n    &:hover {\n      background-color: #555;\n    }\n  }\n  &::-webkit-scrollbar-track {\n    background-color: transparent;\n  }\n"]))),C=function(){var e=localStorage.getItem("game_id");e&&(window.location.href="games/"+e);var n=x("http://52.78.184.142/games","get").data,t=null===n||void 0===n?void 0:n.game_list.map((function(e,n){var t=e.home,r=e.away,a=e.id;return Object(w.jsx)(N,{home:t,away:r,id:a,idx:n},n)}));return e?null:Object(w.jsxs)(T,{children:[Object(w.jsx)(z,{children:"BASEBALL GAME ONLINE"}),Object(w.jsx)(S,{children:"\ucc38\uac00\ud560 \uac8c\uc784\uc744 \uc120\ud0dd\ud558\uc138\uc694!"}),Object(w.jsx)(_,{children:t})]})},I=t(20),B=t(4),L=t(13),E=j.a.div(s||(s=Object(f.a)(["\n  .title {\n    font-size: 2.5rem;\n    font-weight: 600;\n    color: #fff;\n    text-align: center;\n  }\n  .teams {\n    display: grid;\n    grid-template-columns: 1fr 6rem 1fr;\n    text-align: center;\n    align-items: flex-end;\n    padding: 1rem 0;\n    color: #f6f0f0;\n    font-weight: 600;\n    .home,\n    .away {\n      display: flex;\n      align-items: center;\n      font-size: 3rem;\n    }\n    .teams-vs {\n      font-size: 4rem;\n      color: #777;\n    }\n    .teams-name {\n      font-size: 3rem;\n      position: relative;\n    }\n    .turn {\n      position: absolute;\n      padding-top: 0.5rem;\n      font-size: 1.5rem;\n      left: 40%;\n      color: #ff4545;\n    }\n  }\n  .home {\n    justify-content: flex-end;\n    .teams-score {\n      margin: 0 3rem;\n    }\n  }\n  .away {\n    justify-content: flex-start;\n    .teams-score {\n      margin: 0 3rem;\n    }\n  }\n"]))),P=function(e){var n=e.teamName,t=e.selectTeam,r=Object(m.useContext)(Re).score,a="Player",i=r.home.reduce((function(e,n){return e+n}),0),c=r.away.reduce((function(e,n){return e+n}),0);return Object(w.jsxs)(E,{children:[Object(w.jsx)("div",{className:"title",children:"BASEBALL GAME ONLINE"}),Object(w.jsxs)("div",{className:"teams",children:[Object(w.jsxs)("div",{className:"home",children:[Object(w.jsxs)("div",{className:"teams-name",children:[n.home,n.home==t&&Object(w.jsx)("div",{className:"turn",children:a})]}),Object(w.jsx)("div",{className:"teams-score",children:i})]}),Object(w.jsx)("div",{className:"teams-vs",children:"vs"}),Object(w.jsxs)("div",{className:"away",children:[Object(w.jsx)("div",{className:"teams-score",children:c}),Object(w.jsxs)("div",{className:"teams-name",children:[n.away,n.away==t&&Object(w.jsx)("div",{className:"turn",children:a})]})]})]})]})},D=t(26),R=j.a.div(l||(l=Object(f.a)(["\n  height: 100%;\n  padding-bottom: 1.5rem;\n  display: flex;\n  flex-direction: column;\n  justify-content: space-around;\n  font-weight: 600;\n  .player-type {\n    color: #f6f0f0;\n    font-size: 2rem;\n    margin-bottom: 0.5rem;\n  }\n  .player-detail {\n    display: flex;\n    font-size: 1.5rem;\n    .name {\n      color: #cff0f7;\n      margin-right: 0.5rem;\n    }\n    .detail {\n      color: #79b5ce;\n    }\n  }\n"]))),A=function(e){var n=e.memberList,t=e.turn,r=e.pitchers,a="home",i="away",c=function(){if(n&&n.home&&n.away){var e,c={},o=t?a:i,s=t?i:a,l=Object(D.a)(n[o]);try{for(l.s();!(e=l.n()).done;){var d=e.value;d.status&&(c.batter=d)}}catch(h){l.e(h)}finally{l.f()}var m,u=Object(D.a)(n[s]);try{for(u.s();!(m=u.n()).done;){var b=m.value;b.id===r[s]&&(c.pitcher=b)}}catch(h){u.e(h)}finally{u.f()}return c}}();return Object(w.jsxs)(R,{children:[Object(w.jsxs)("div",{className:"player",children:[Object(w.jsx)("div",{className:"player-type",children:"\ud22c\uc218"}),Object(w.jsxs)("div",{className:"player-detail",children:[Object(w.jsx)("div",{className:"name",children:null===c||void 0===c?void 0:c.pitcher.name}),Object(w.jsxs)("div",{className:"detail",children:["#",null===c||void 0===c?void 0:c.pitcher.id]})]})]}),Object(w.jsxs)("div",{className:"player",children:[Object(w.jsx)("div",{className:"player-type",children:"\ud0c0\uc790"}),Object(w.jsxs)("div",{className:"player-detail",children:[Object(w.jsx)("div",{className:"name",children:null===c||void 0===c?void 0:c.batter.name}),Object(w.jsxs)("div",{className:"detail",children:[(null===c||void 0===c?void 0:c.batter.atBat)||0,"\ud0c0\uc11d ",(null===c||void 0===c?void 0:c.batter.plate_appearance)||0,"\uc548\ud0c0"]})]})]})]})};function J(e){for(var n=[],t=0;t<e;t++)n.push(Object(w.jsx)("div",{},t));return n}var F,M,Y,G,H,W,X,U,q,K,Q,V,Z,$,ee,ne,te,re=j.a.div(d||(d=Object(f.a)(["\n  color:#fff;\n  font-weight:600;\n  .counters {\n    display: flex;\n    margin-bottom:0.5rem;\n    & > div {\n      font-size: 1.5rem;\n      margin-right: 0.5rem;\n      width: 1.5rem;\n      height: 1.5rem;\n      line-height: 1.3rem;\n    }\n    & > div:not(:first-child) {\n      border-radius: 50%;\n      width: 1.5rem;\n      height: 1.5rem;\n    }\n  }\n  .strike{\n    & > div:not(:first-child) {\n      background-color:yellow;\n    }\n  }\n  .ball{\n    & > div:not(:first-child) {\n      background-color:green;\n    }\n  }\n  .out{\n    & > div:not(:first-child) {\n      background-color:red;\n    }\n  }\n"]))),ae=function(e){var n=e.ballCount,t=n.strike,r=n.ball,a=n.out;return Object(w.jsxs)(re,{children:[Object(w.jsxs)("div",{className:"counters strike",children:[Object(w.jsx)("div",{children:"S"}),J(t)]}),Object(w.jsxs)("div",{className:"counters ball",children:[Object(w.jsx)("div",{children:"B"}),J(r)]}),Object(w.jsxs)("div",{className:"counters out",children:[Object(w.jsx)("div",{children:"O"}),J(a)]})]})},ie=j.a.div(F||(F=Object(f.a)(["\n  font-size: 1.5rem;\n  font-weight: 600;\n  color: #fff;\n  text-align: right;\n"]))),ce=function(e){var n=e.inning,t=n.turn,r=n.round,a=e.isHome;return Object(w.jsxs)(ie,{children:[r,"\ud68c",t?"\ucd08":"\ub9d0"," ",a&&t||!a&&!t?"\uacf5\uaca9":"\uc218\ube44"]})},oe=function(e){var n=e.score,t=void 0===n?{home:[0],away:[]}:n,r=e.base,a=void 0===r?{1:!1,2:!1,3:!1}:r,i=Object(m.useState)(t),c=Object(O.a)(i,2),o=c[0],s=c[1],l=Object(m.useState)(a),d=Object(O.a)(l,2),u=d[0],b=d[1];return{score:o,base:u,safetyDispatch:function(e){var n=e.type,t=e.turn,r=e.runFirstBase,a=t?"home":"away";switch(n){case"clear":var i=Object(B.a)({},o);return i[a].push(0),s(i),void b({1:!1,2:!1,3:!1});case"onBase":return b(function(e,n){var t=Object(B.a)({},e),r=Object.values(t);return(n?[!0].concat(Object(L.a)(r.slice(0,-1))):[!1].concat(Object(L.a)(r.slice(0,-1)))).forEach((function(e,n){return t[n+1]=e})),t}(u,r)),void s(function(e,n){if(!u[3])return e;var t=Object(B.a)({},e);return t[n][t[n].length-1]+=1,t}(o,a));default:throw Error("\uc798\ubabb\ub41c safetyDispatch \ud0c0\uc785\uc785\ub2c8\ub2e4.")}}}},se=j.a.div(M||(M=Object(f.a)(["\n  position: relative;\n  align-self: center;\n"]))),le=j.a.button(Y||(Y=Object(f.a)(["\n  position: absolute;\n  top: calc(50% - 1.5rem);\n  left: calc(50% - 5rem);\n  display: inline;\n  width: 10rem;\n  height: 3rem;\n  font-size: 2rem;\n  font-weight: 600;\n  border: 2px solid #fff;\n  border-radius: 0.5rem;\n  background: transparent;\n  color: #fff;\n  cursor: pointer;\n  transition: all 0.1s linear;\n  z-index: 1;\n  &:hover {\n    background-color: #fff;\n    color: #000;\n  }\n"]))),de=j.a.div(G||(G=Object(f.a)(["\n  position: relative;\n  border: 3px solid #fff;\n  width: 20rem;\n  height: 20rem;\n  margin: auto;\n  transform: rotate(-45deg);\n  .runner {\n    width: 1.5rem;\n    height: 1.5rem;\n    background-color: red;\n    transition: ",";\n  }\n\n  .home {\n    z-index: 4;\n  }\n  .base {\n    position: absolute;\n    display: flex;\n    align-items: center;\n    justify-content: center;\n    background-color: #fff;\n    width: 2rem;\n    height: 2rem;\n    &:nth-child(1) {\n      bottom: -1rem;\n      left: -1rem;\n      .runner {\n        background-color: ",";\n        transform: ",";\n      }\n      &:before {\n        content: '';\n        background-color: #fff;\n        width: 2.8284712rem;\n        height: 4rem;\n        position: absolute;\n        bottom: -2.45rem;\n        left: -1.88rem;\n        transform: rotate(45deg);\n      }\n    }\n    &:nth-child(2) {\n      z-index: 3;\n      bottom: -1rem;\n      right: -1rem;\n      .runner {\n        background-color: ",";\n        transform: ",";\n      }\n    }\n    &:nth-child(3) {\n      z-index: 2;\n      top: -1rem;\n      right: -1rem;\n      .runner {\n        background-color: ",";\n        transform: ",";\n      }\n    }\n    &:nth-child(4) {\n      z-index: 1;\n      top: -1rem;\n      left: -1rem;\n      .runner {\n        background-color: ",";\n        transform: ",";\n      }\n    }\n  }\n"])),(function(e){return e.isTransition?"all 0.5s":""}),(function(e){return e.runFirstBase?"red":"rgba(0,0,0,0)"}),(function(e){var n=e.playerRunType,t=e.currentPower;return e.runFirstBase&&t>0?"".concat(n[0]," rotate(45deg)"):"rotate(45deg)"}),(function(e){return e.base[1]?"red":"rgba(0,0,0,0)"}),(function(e){var n=e.playerRunType;return e.currentPower>0?"".concat(n[1]," rotate(45deg)"):"rotate(45deg)"}),(function(e){return e.base[2]?"red":"rgba(0,0,0,0)"}),(function(e){var n=e.playerRunType;return e.currentPower>0?"".concat(n[2]," rotate(45deg)"):"rotate(45deg)"}),(function(e){return e.base[3]?"red":"rgba(0,0,0,0)"}),(function(e){var n=e.playerRunType;return e.currentPower>0?"".concat(n[3]," rotate(45deg)"):"rotate(45deg)"})),me=function(e){var n=e.handleStrike,t=e.handleBall,r=e.handleSafety,a=e.ballCount,i=e.turn,c=e.teamName,o=e.selectTeam,s=Object(m.useContext)(Re),l=s.base,d=s.safetyDispatch,u=Object(m.useState)(!1),b=Object(O.a)(u,2),h=b[0],f=b[1],j=Object(m.useState)(!1),p=Object(O.a)(j,2),x=p[0],y=p[1],k=Object(m.useState)(0),N=Object(O.a)(k,2),T=N[0],z=N[1],S=function(){var e=Object(g.a)(v.a.mark((function e(){return v.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:if(0!==T){e.next=2;break}return e.abrupt("return");case 2:y(!1),z(T-1),d({type:"onBase",turn:i,runFirstBase:x}),f(!1);case 6:case"end":return e.stop()}}),e)})));return function(){return e.apply(this,arguments)}}(),_=Object.entries(l).map((function(e,n){var t=Object(O.a)(e,2);t[0],t[1];return Object(w.jsx)("div",{className:"base",children:Object(w.jsx)("div",{className:"runner"})},n)}));i&&c.home!=o||!i&&c.away,Object(m.useRef)();return Object(w.jsxs)(se,{children:[Object(w.jsx)(le,{onClick:function(){var e=Math.ceil(100*Math.random());e<=55?n():e<=80?(3===a.ball&&(z(1),f(!0),y(!0)),t()):(f(!0),y(!0),r(),z(e<=100?1:e<=6?2:e<=3?3:4))},children:"PITCH"}),Object(w.jsxs)(de,{playerRunType:["translateX(19.6rem)","translateY(-19.6rem)","translateX(-19.6rem)","translateY(19.6rem)"],currentPower:T,runFirstBase:x,isTransition:h,base:l,onTransitionEnd:S,children:[Object(w.jsx)("div",{className:"base home",children:Object(w.jsx)("div",{className:"runner"})}),_]})]})},ue=function(){var e=Object(g.a)(v.a.mark((function e(n,t){var r;return v.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,fetch(n,{method:"PUT",headers:{"Content-Type":"application/json"},body:JSON.stringify(t)});case 2:r=e.sent,console.log(r);case 4:case"end":return e.stop()}}),e)})));return function(n,t){return e.apply(this,arguments)}}(),be=function(){var e=Object(g.a)(v.a.mark((function e(n,t){var r;return v.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return console.log(t),e.next=3,fetch(n,{method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify(t)});case 3:r=e.sent,console.log(r);case 5:case"end":return e.stop()}}),e)})));return function(n,t){return e.apply(this,arguments)}}(),he="http://52.78.184.142",fe=function(e,n){var t=Object(B.a)({},e);switch(n.type){case"strike":t.strike++;break;case"ball":t.ball++;break;case"safety":t={strike:0,ball:0,out:t.out};break;case"clear":t={strike:0,ball:0,out:0};break;case"out":t.ball=0,t.strike=0,t.out++;break;default:throw Error("\uc798\ubabb\ub41c ball-count reducer")}return t},je=j.a.div(H||(H=Object(f.a)(["\n  display: grid;\n  grid-template-columns: 10rem 1fr 10rem;\n"]))),pe=function(e){var n=e.memberListDispatch,t=e.inning,r=e.setInning,a=e.logListDispatch,i=e.game_id,c=e.teamName,o=e.teamId,s=e.selectTeam,l=e.memberList,d=Object(m.useReducer)(fe,{strike:0,ball:0,out:0}),u=Object(O.a)(d,2),b=u[0],h=u[1],f=Object(m.useContext)(Re),j=f.score,p=f.base,v=f.safetyDispatch,g=Object(m.useContext)(Ae).gameID,x=function(){var e;return null===(e=l[t.turn?"home":"away"].find((function(e){return e.status})))||void 0===e?void 0:e.id},y={game_id:g,home:j.home[t.round-1]+t.turn,away:t.turn?null:j.away[t.round-1]+1,round:t.round},k=function(){var e=x();2===b.out?(be("".concat(he,"/games/").concat(g),{game_id:g,round:t.round,player_id:e,team_id:t.turn?o.home:o.away}),h({type:"clear"}),t.turn?r(Object(B.a)(Object(B.a)({},t),{},{turn:!t.turn})):r(Object(B.a)(Object(B.a)({},t),{},{round:t.round+1,turn:!t.turn})),v({type:"clear",turn:!t.turn}),a({type:"clear"})):(ue("".concat(he,"/players/").concat(e),{game_id:g,at_bat:!1}),a({type:"out",end:!0}),h({type:"out"})),n({type:"out",turn:t.turn,game_id:i})};return Object(w.jsxs)(je,{children:[Object(w.jsx)(ae,{ballCount:b}),Object(w.jsx)(me,{handleStrike:function(){2===b.strike?k():(h({type:"strike"}),a(Object(B.a)(Object(B.a)({type:"strike"},b),{},{strike:b.strike+1})))},handleBall:function(){if(3===b.ball){p[3]&&ue("".concat(he,"/games/").concat(g),y);var e=x();ue("".concat(he,"/players/").concat(e),{game_id:g,at_bat:!0}),h({type:"safety"}),a({type:"4ball",end:!0}),n({type:"safety",turn:t.turn,game_id:i})}else h({type:"ball"}),a(Object(B.a)(Object(B.a)({type:"ball"},b),{},{ball:b.ball+1}))},handleSafety:function(){p[3]&&ue("".concat(he,"/games/").concat(g),y);var e=x();ue("".concat(he,"/players/").concat(e),{game_id:g,at_bat:!0}),h({type:"safety"}),n({type:"safety",turn:t.turn,game_id:i}),a({type:"safety",end:!0})},ballCount:b,teamName:c,selectTeam:s,turn:t.turn}),Object(w.jsx)(ce,{inning:t,isHome:ve})]})},ve=!0,ge={strike:"\uc2a4\ud2b8\ub77c\uc774\ud06c",ball:"\ubcfc",safety:"\uc548\ud0c0","4ball":"\ubcfc\ub137",out:"\uc544\uc6c3"},Oe=j.a.div(W||(W=Object(f.a)(["\n  .logs {\n    display: flex;\n    flex-flow: column-reverse;\n    .log:not(:first-child) {\n      margin-bottom: 2.5rem;\n    }\n    font-size: 1.125rem;\n  }\n  .contents {\n    display: flex;\n    flex-flow: column-reverse;\n  }\n  .contents > div {\n    margin-bottom: 0.75rem;\n  }\n  .title {\n    color: #cff0f7;\n    font-weight: 600;\n    margin-bottom: 1rem;\n  }\n  .content {\n    display: grid;\n    grid-template-columns: 1.25rem 3fr 1fr;\n    text-align: center;\n    margin-bottom: 0.5rem;\n    *:nth-child(1) {\n      color: #000;\n      background-color: #f1f1f1;\n      border-radius: 50%;\n    }\n    *:nth-child(2) {\n      color: #f1f1f1;\n      font-weight: 600;\n    }\n    *:nth-child(3) {\n      color: #aaa;\n      font-weight: 600;\n    }\n  }\n  .content.result {\n    *:nth-child(1) {\n      background-color: transparent;\n    }\n    *:nth-child(2) {\n      color: #79b5ce;\n    }\n  }\n  .active {\n    .title {\n      color: #ff7878;\n    }\n    .content.result > * {\n      color: #ff4545;\n    }\n  }\n"]))),xe=function(e){var n=e.logList,t=n.map((function(e,t){return Object(w.jsxs)("div",{className:"log "+(t+1===n.length?"active":""),children:[Object(w.jsxs)("div",{className:"title",children:[e.index,"\ubc88 \ud0c0\uc790 ",e.name]}),Object(w.jsx)("div",{className:"contents",children:e.history.map((function(e,n){return e.end?Object(w.jsxs)("div",{className:"content result",children:[Object(w.jsx)("div",{}),Object(w.jsxs)("div",{children:[ge[e.type],"!"]}),Object(w.jsx)("div",{})]},n):Object(w.jsxs)("div",{className:"content",children:[Object(w.jsx)("div",{children:n+1}),Object(w.jsx)("div",{children:ge[e.type]}),Object(w.jsxs)("div",{children:["S",e.strike," B",e.ball]})]},n)}))})]},t)}));return Object(w.jsx)(Oe,{children:Object(w.jsx)("div",{className:"logs",children:t})})},ye=t(34),we=j.a.div(X||(X=Object(f.a)(["\n  display: flex;\n\n  .team-wrapper {\n    margin-right: 2rem;\n    .team {\n      position: relative;\n      width: 8rem;\n      font-size: 1.1rem;\n      font-weight: 700;\n      .baseball {\n        position: absolute;\n        top: 0.2rem;\n        left: -1.7rem;\n        margin-right: 0.2rem;\n      }\n      span {\n        text-align: center;\n      }\n    }\n    .turn {\n      color: #ff4545;\n      font-weight: 600;\n      text-align: center;\n    }\n  }\n\n  .score-list {\n    border-bottom: ",";\n    margin-bottom: ",";\n  }\n  .score {\n    display: flex;\n    justify-content: center;\n    font-size: 1.5rem;\n    font-weight: 700;\n    width: 3rem;\n    height: ",";\n    margin-right: 1rem;\n  }\n  .last-score {\n    color: #ff4545;\n  }\n  .score-list {\n    display: flex;\n  }\n"])),(function(e){return e.isInRound&&"3px solid #fff"}),(function(e){return e.isInRound?"1rem":"0.3rem"}),(function(e){return e.isInRound?"2.7rem":"3rem"})),ke=function(e){var n=e.team,t=e.dataType,r=e.data,a=e.isPlayer,i="round"===t,c=new Array(12).fill("");r.forEach((function(e,n){return c[n]=e})),i?c.push("R"):c.push(r.reduce((function(e,n){return e+n}),0));var o=c.map((function(e,n,t){return Object(w.jsx)("div",{className:n!==t.length-1||i?"score":"score last-score",children:e},n+1)}));return Object(w.jsxs)(we,{isInRound:i,children:[Object(w.jsxs)("div",{className:"team-wrapper",children:[Object(w.jsxs)("div",{className:"team",children:[a&&Object(w.jsx)(ye.a,{className:"baseball"}),Object(w.jsx)("div",{children:n||""})]}),a&&Object(w.jsx)("div",{className:"turn",children:"player"})]}),Object(w.jsx)("div",{className:"score-list",children:o})]})},Ne=j.a.div(U||(U=Object(f.a)(["\n  width: 70rem;\n  min-width: 63rem;\n  display: flex;\n  flex-direction: column;\n  align-items: center;\n  justify-content: center;\n  padding: 2rem 0 0.8rem 0;\n  margin: 3rem auto;\n  color: #fff;\n  border: 3px solid #fff;\n"]))),Te=function(e){var n=e.score,t=e.teamName,r=e.gameID,a=("http://52.78.184.142/games/".concat(r,"/detail-score"),new Array(12).fill().map((function(e,n){return n+1})));return n&&n.home&&Object(w.jsxs)(Ne,{children:[Object(w.jsx)(ke,{dataType:"round",data:a}),Object(w.jsx)(ke,{team:t.home,dataType:"home",data:n.home,isPlayer:!0}),Object(w.jsx)(ke,{team:t.away,dataType:"away",data:n.away,isPlayer:!1})]})},ze=function(e){var n=e.name,t=e.atBat,r=e.plate_appearance,a=e.outCount,i="roster--member"+(n===e.player_name?" active":"");return Object(w.jsxs)("li",{className:i,children:[Object(w.jsx)("div",{children:n}),Object(w.jsx)("div",{children:t}),Object(w.jsx)("div",{children:r}),Object(w.jsx)("div",{children:a}),Object(w.jsx)("div",{children:function(e,n){return n/e?(n/e).toFixed(3):0}(t,r)})]})},Se=j.a.div(q||(q=Object(f.a)(["\n  .title {\n    font-size: 1.5rem;\n    font-weight: 600;\n    color: #fff;\n    border-bottom: 3px solid #fff;\n    text-align: center;\n    padding-top: 0.5rem;\n    padding-bottom: 1rem;\n    .player {\n      display: inline-block;\n      color: #ff4545;\n      font-size: 0.75rem;\n      font-weight: 600;\n      position: relative;\n      top: -0.25rem;\n    }\n  }\n  ul {\n    padding: 0;\n    margin: 0;\n  }\n  .roster {\n    li {\n      display: grid;\n      grid-template-columns: 2fr 1fr 1fr 1fr 1.5fr;\n      color: #d2d2d2;\n      font-size: 1.25rem;\n      text-align: center;\n      padding: 0.625rem;\n      &:not(:last-child) {\n        border-bottom: 1px solid #555;\n      }\n    }\n    li.roster--head {\n      border-bottom: 2px solid #777;\n      color: #aaa;\n    }\n    li.roster--total {\n      color: #fff;\n      font-weight: 600;\n    }\n    li.roster--member {\n    }\n    .roster--member.active {\n      color: #ff4545;\n    }\n  }\n"]))),_e=function(e){var n=e.memberList,t=e.teamName,r=e.selectTeam,a=["\ud0c0\uc790","\ud0c0\uc11d","\uc548\ud0c0","\uc544\uc6c3","\ud3c9\uade0"].map((function(e,n){return Object(w.jsx)("div",{children:e},n)})),i=0,c=0,o=0,s=n.map((function(e,n){var t=e.atBat,r=e.plate_appearance,a=e.outCount;return i+=t,c+=r,o+=a,Object(m.createElement)(ze,Object(B.a)(Object(B.a)({},e),{},{player_name:"abc",key:n}))}));return Object(w.jsxs)(Se,{children:[Object(w.jsxs)("div",{className:"title",children:[t," ",t===r&&Object(w.jsx)("div",{className:"player",children:"Player"})]}),Object(w.jsxs)("ul",{className:"roster",children:[Object(w.jsx)("li",{className:"roster--head",children:a}),s,Object(w.jsxs)("li",{className:"roster--total",children:[Object(w.jsx)("div",{children:"Totals"}),Object(w.jsx)("div",{children:i}),Object(w.jsx)("div",{children:c}),Object(w.jsx)("div",{children:o}),Object(w.jsx)("div",{})]})]})]})},Ce=j.a.div(K||(K=Object(f.a)(["\n  margin: 0 auto;\n  max-width: 60vw;\n  margin-top: 5rem;\n  border: 3px solid #fff;\n  padding: 0.5rem 1rem;\n  display: grid;\n  grid-template-columns: 1fr 1fr;\n  & > *:first-child {\n    border-right: 1.5px solid #fff;\n  }\n  & > *:last-child {\n    border-left: 1.5px solid #fff;\n  }\n"]))),Ie=function(e){var n=e.memberList,t=e.teamName,r=e.selectTeam;return Object(w.jsxs)(Ce,{children:[Object(w.jsx)(_e,{memberList:n.home,teamName:t.home,selectTeam:r}),Object(w.jsx)(_e,{memberList:n.away,teamName:t.away,selectTeam:r})]})},Be=Object(j.b)(Q||(Q=Object(f.a)(["\n0% {\n  margin-top: -40rem;\n}\n100% {\n  margin-top: 0rem;\n}\n"]))),Le=Object(j.b)(V||(V=Object(f.a)(["\n0% {\n  transform: translateY(30rem);\n}\n100% {\n  transform: translateY(0rem);\n}\n"]))),Ee=j.a.div(Z||(Z=Object(f.a)(["\n  position: absolute;\n  top: 0;\n  width: 100vw;\n  height: 100vh;\n  z-index: 2;\n  text-align: center;\n  &:before {\n    background-color: rgba(0, 0, 0, 0.9);\n    content: '';\n    position: absolute;\n    top: 0;\n    left: 0;\n    width: 100vw;\n    height: 100vh;\n    z-index: -1;\n  }\n  &.active > * {\n    animation: "," 0.5s cubic-bezier(0.33, 1, 0.68, 1);\n  }\n"])),(function(e){return"top"===e.position?Be:Le})),Pe=j.a.div($||($=Object(f.a)(["\n  width: 10vw;\n  height: 3rem;\n  position: absolute;\n  right: 30vw;\n  cursor: pointer;\n  color: #eee;\n  border-radius: ",";\n  background-color: rgba(0, 0, 0, 0.5);\n  top: ",";\n  bottom: ",";\n  text-align: center;\n  font-size: 1.25rem;\n  padding: 0.5rem 0;\n  &:hover {\n    background-color: rgba(0, 0, 0, 0.8);\n  }\n"])),(function(e){return"top"===e.position?"0 0 1rem 1rem":"1rem 1rem 0 0"}),(function(e){return"top"===e.position&&"0px"}),(function(e){return"bottom"===e.position&&"0px"})),De=function(e){var n=e.children,t=e.position,r=e.emptyText,a=void 0===r?"":r,i=Object(m.useState)(!1),c=Object(O.a)(i,2),o=c[0],s=c[1];return o?Object(w.jsx)(Ee,{onClick:function(e){var n=e.target;return("childrenWrapper"===n.className||!n.closest(".childrenWrapper"))&&s(!1)},className:o?"active":"",position:t,children:Object(w.jsx)("div",{className:"childrenWrapper",children:n})}):Object(w.jsx)(Pe,{position:t,onClick:function(){return s(!0)},children:a})},Re=Object(m.createContext)(),Ae=Object(m.createContext)(),Je=function(e,n){if("init"===n.type)return n.value;var t=0,r=n.turn?"home":"away",a=Object(L.a)(e[r]).map((function(e,r,a){var i=e.plate_appearance,c=e.atBat,o=e.outCount,s=e.status;return e.status?("out"===n.type?o++:i++,c++,t=r+1===a.length?0:r+1,Object(B.a)(Object(B.a)({},e),{},{plate_appearance:i,atBat:c,outCount:o,status:!s})):Object(B.a)({},e)}));return a[t].status=!0,Object(B.a)(Object(B.a)({},e),{},Object(I.a)({},r,a))},Fe=function(e,n){var t=Object(L.a)(e),r=t.length>0&&Object(B.a)({},t[t.length-1]);switch(n.type){case"next":t.push(Object(B.a)(Object(B.a)({},n.value),{},{index:n.index,history:[]}));break;case"strike":case"ball":r.history=[].concat(Object(L.a)(r.history),[Object(B.a)({},n)]),t[t.length-1]=r;break;case"4ball":case"safety":case"out":r.history=[].concat(Object(L.a)(r.history),[{type:n.type,end:!0}]),r.status=!1,t[t.length-1]=r;break;case"clear":t=[]}return t},Me=j.a.div(ee||(ee=Object(f.a)([""]))),Ye=j.a.div(ne||(ne=Object(f.a)(["\n  display: grid;\n  grid-template-columns: 3fr minmax(19.5rem, 1fr);\n  grid-template-rows: minmax(14.5rem, 25vh) 75vh;\n  & > div:nth-child(1),\n  & > div:nth-child(3) {\n    padding: 1.5rem 1.5rem 0 1.5rem;\n  }\n  & > div:nth-child(2),\n  & > div:nth-child(4) {\n    border-left: 3px solid #bbb;\n    padding: 1.5rem 2rem 0rem 2rem;\n  }\n  & > div:nth-child(1),\n  & > div:nth-child(2) {\n    border-bottom: 3px solid #bbb;\n    padding: 1.5rem 2rem;\n  }\n  & > div:nth-child(4) {\n    overflow-y: scroll;\n    &::-webkit-scrollbar {\n      width: 0.875rem;\n    }\n    &::-webkit-scrollbar-thumb {\n      background-color: #999;\n      border-radius: 0.375rem;\n      &:hover {\n        background-color: #555;\n      }\n    }\n    &::-webkit-scrollbar-track {\n      background-color: transparent;\n    }\n  }\n"]))),Ge=function(e){e.home,e.away,e.game_id;var n,t,r,a,i,c,o=window.location.pathname,s=+o.slice(7),l=localStorage.getItem("select");localStorage.setItem("game_id",s);var d=x("http://52.78.184.142"+o,"get").data,u=Object(m.useState)({turn:!0,round:1}),b=Object(O.a)(u,2),h=b[0],f=b[1],j=Object(m.useReducer)(Fe,[]),p=Object(O.a)(j,2),v=p[0],g=p[1],y=oe({score:{home:[0],away:[]},base:void 0}),k=y.score,N=y.base,T=y.safetyDispatch,z=Object(m.useReducer)(Je,null),S=Object(O.a)(z,2),_=S[0],C=S[1],I={home:null===d||void 0===d||null===(n=d.home)||void 0===n?void 0:n.teamId,away:null===d||void 0===d||null===(t=d.away)||void 0===t?void 0:t.teamId},L={home:null===d||void 0===d||null===(r=d.home)||void 0===r?void 0:r.name,away:null===d||void 0===d||null===(a=d.away)||void 0===a?void 0:a.name},E={home:null===d||void 0===d||null===(i=d.home)||void 0===i?void 0:i.pitcherId,away:null===d||void 0===d||null===(c=d.away)||void 0===c?void 0:c.pitcherId};return Object(m.useEffect)((function(){var e,n,t={home:null===d||void 0===d||null===(e=d.home)||void 0===e?void 0:e.member_list,away:null===d||void 0===d||null===(n=d.away)||void 0===n?void 0:n.member_list};f({turn:(null===d||void 0===d?void 0:d.turn)||!0,round:(null===d||void 0===d?void 0:d.round)||1}),C({type:"init",value:t})}),[d]),Object(m.useEffect)((function(){_&&_.home&&_[h.turn?"home":"away"].forEach((function(e,n){e.status&&g({value:Object(B.a)({},e),type:"next",index:n+1})}))}),[_]),Object(w.jsx)(Ae.Provider,{value:{gameID:s},children:Object(w.jsxs)(Me,{children:[Object(w.jsx)(De,{position:"top",emptyText:"\uc0c1\uc138 \uc810\uc218",children:Object(w.jsx)(Te,{score:k,teamName:L,selectTeam:l})}),Object(w.jsx)(De,{position:"bottom",emptyText:"\uc120\uc218 \uba85\ub2e8",children:Object(w.jsx)(Ie,{memberList:_,teamName:L,selectTeam:l})}),Object(w.jsx)(Ye,{children:Object(w.jsxs)(Re.Provider,{value:{score:k,base:N,safetyDispatch:T},children:[Object(w.jsx)(P,{teamName:L,turn:h.turn,gameID:s,selectTeam:l}),Object(w.jsx)(A,{memberList:_,turn:h.turn,pitchers:E}),Object(w.jsx)(pe,{inning:h,setInning:f,memberListDispatch:C,logListDispatch:g,game_id:s,teamName:L,teamId:I,selectTeam:l,memberList:_}),Object(w.jsx)(xe,{logList:v})]})})]})})},He=t.p+"static/media/background.9127295c.png",We=t(5);var Xe=j.a.div(te||(te=Object(f.a)(["\n  background-image: url(",");\n  background-size: cover;\n  position: absolute;\n  top: 0;\n  width: 100vw;\n  height: 100vh;\n  z-index: -1;\n  &:before {\n    background-color: rgba(0, 0, 0, 0.8);\n    content: '';\n    position: absolute;\n    top: 0;\n    left: 0;\n    width: 100vw;\n    height: 100vh;\n    z-index: -1;\n  }\n"])),(function(e){return e.src})),Ue=function(){return Object(w.jsxs)(y.a,{children:[Object(w.jsx)(Xe,{src:He}),Object(w.jsx)(We.a,{exact:!0,path:"/",children:Object(w.jsx)(C,{})}),Object(w.jsx)(We.a,{path:"/games",children:Object(w.jsx)(Ge,{})})]})};h.a.render(Object(w.jsx)(u.a.StrictMode,{children:Object(w.jsx)(Ue,{})}),document.getElementById("root"))}},[[50,1,2]]]);
//# sourceMappingURL=main.1bcfabba.chunk.js.map