!function(e,t){"object"==typeof exports&&"undefined"!=typeof module?module.exports=t():"function"==typeof define&&define.amd?define(t):e.Sweetalert2=t()}(this,function(){"use strict";var e={title:"",titleText:"",text:"",html:"",type:null,toast:!1,customClass:"",target:"body",backdrop:!0,animation:!0,allowOutsideClick:!0,allowEscapeKey:!0,allowEnterKey:!0,showConfirmButton:!0,showCancelButton:!1,preConfirm:null,confirmButtonText:"OK",confirmButtonAriaLabel:"",confirmButtonColor:"#3085d6",confirmButtonClass:null,cancelButtonText:"Cancel",cancelButtonAriaLabel:"",cancelButtonColor:"#aaa",cancelButtonClass:null,buttonsStyling:!0,reverseButtons:!1,focusConfirm:!0,focusCancel:!1,showCloseButton:!1,closeButtonAriaLabel:"Close this dialog",showLoaderOnConfirm:!1,imageUrl:null,imageWidth:null,imageHeight:null,imageAlt:"",imageClass:null,timer:null,width:500,padding:20,background:"#fff",input:null,inputPlaceholder:"",inputValue:"",inputOptions:{},inputAutoTrim:!0,inputClass:null,inputAttributes:{},inputValidator:null,grow:!1,position:"center",progressSteps:[],currentProgressStep:null,progressStepsDistance:"40px",onBeforeOpen:null,onOpen:null,onClose:null,useRejections:!1,expectRejections:!1},t=["useRejections","expectRejections"],n=function(e){var t={};for(var n in e)t[e[n]]="swal2-"+e[n];return t},o=n(["container","shown","iosfix","popup","modal","no-backdrop","toast","toast-shown","overlay","fade","show","hide","noanimation","close","title","content","contentwrapper","buttonswrapper","confirm","cancel","icon","image","input","has-input","file","range","select","radio","checkbox","textarea","inputerror","validationerror","progresssteps","activeprogressstep","progresscircle","progressline","loading","styled","top","top-left","top-right","center","center-left","center-right","bottom","bottom-left","bottom-right","grow-row","grow-column","grow-fullscreen"]),r=n(["success","warning","info","question","error"]),i=function(e,t){(e=String(e).replace(/[^0-9a-f]/gi,"")).length<6&&(e=e[0]+e[0]+e[1]+e[1]+e[2]+e[2]),t=t||0;for(var n="#",o=0;o<3;o++){var r=parseInt(e.substr(2*o,2),16);n+=("00"+(r=Math.round(Math.min(Math.max(0,r+r*t),255)).toString(16))).substr(r.length)}return n},a=function(e){console.warn("SweetAlert2: "+e)},s=function(e){console.error("SweetAlert2: "+e)},l=[],u={previousWindowKeyDown:null,previousActiveElement:null,previousBodyPadding:null},c=function(e){var t=p();t&&(t.parentNode.removeChild(t),L(document.body,o["no-backdrop"]),L(document.body,o["has-input"]),L(document.body,o["toast-shown"]));{if("undefined"!=typeof document){var n=document.createElement("div");n.className=o.container,n.innerHTML=d;("string"==typeof e.target?document.querySelector(e.target):e.target).appendChild(n);var r=f(),i=T(r,o.input),a=T(r,o.file),l=r.querySelector("."+o.range+" input"),u=r.querySelector("."+o.range+" output"),c=T(r,o.select),m=r.querySelector("."+o.checkbox+" input"),b=T(r,o.textarea);return i.oninput=function(){K.resetValidationError()},a.onchange=function(){K.resetValidationError()},l.oninput=function(){K.resetValidationError(),u.value=l.value},l.onchange=function(){K.resetValidationError(),l.previousSibling.value=l.value},c.onchange=function(){K.resetValidationError()},m.onchange=function(){K.resetValidationError()},b.oninput=function(){K.resetValidationError()},r}s("SweetAlert2 requires document to initialize")}},d=('\n <div role="dialog" aria-modal="true" aria-labelledby="'+o.title+'" aria-describedby="'+o.content+'" class="'+o.popup+'" tabindex="-1">\n   <ul class="'+o.progresssteps+'"></ul>\n   <div class="'+o.icon+" "+r.error+'">\n     <span class="swal2-x-mark"><span class="swal2-x-mark-line-left"></span><span class="swal2-x-mark-line-right"></span></span>\n   </div>\n   <div class="'+o.icon+" "+r.question+'">?</div>\n   <div class="'+o.icon+" "+r.warning+'">!</div>\n   <div class="'+o.icon+" "+r.info+'">i</div>\n   <div class="'+o.icon+" "+r.success+'">\n     <div class="swal2-success-circular-line-left"></div>\n     <span class="swal2-success-line-tip"></span> <span class="swal2-success-line-long"></span>\n     <div class="swal2-success-ring"></div> <div class="swal2-success-fix"></div>\n     <div class="swal2-success-circular-line-right"></div>\n   </div>\n   <img class="'+o.image+'" />\n   <div class="'+o.contentwrapper+'">\n   <h2 class="'+o.title+'" id="'+o.title+'"></h2>\n   <div id="'+o.content+'" class="'+o.content+'"></div>\n   </div>\n   <input class="'+o.input+'" />\n   <input type="file" class="'+o.file+'" />\n   <div class="'+o.range+'">\n     <output></output>\n     <input type="range" />\n   </div>\n   <select class="'+o.select+'"></select>\n   <div class="'+o.radio+'"></div>\n   <label for="'+o.checkbox+'" class="'+o.checkbox+'">\n     <input type="checkbox" />\n   </label>\n   <textarea class="'+o.textarea+'"></textarea>\n   <div class="'+o.validationerror+'" id="'+o.validationerror+'"></div>\n   <div class="'+o.buttonswrapper+'">\n     <button type="button" class="'+o.confirm+'">OK</button>\n     <button type="button" class="'+o.cancel+'">Cancel</button>\n   </div>\n   <button type="button" class="'+o.close+'">×</button>\n </div>\n').replace(/(^|\n)\s*/g,""),p=function(){return document.body.querySelector("."+o.container)},f=function(){return p()?p().querySelector("."+o.popup):null},m=function(e){return p()?p().querySelector("."+e):null},b=function(){return m(o.title)},h=function(){return m(o.content)},g=function(){return m(o.image)},v=function(){return m(o.progresssteps)},y=function(){return m(o.validationerror)},w=function(){return m(o.confirm)},C=function(){return m(o.cancel)},x=function(){return m(o.buttonswrapper)},k=function(){return m(o.close)},S=function(){var e=Array.from(f().querySelectorAll('[tabindex]:not([tabindex="-1"]):not([tabindex="0"])')).sort(function(e,t){return e=parseInt(e.getAttribute("tabindex")),t=parseInt(t.getAttribute("tabindex")),e>t?1:e<t?-1:0}),t=Array.prototype.slice.call(f().querySelectorAll('button, input:not([type=hidden]), textarea, select, a, [tabindex="0"]'));return function(e){var t=[];for(var n in e)-1===t.indexOf(e[n])&&t.push(e[n]);return t}(e.concat(t))},A=function(){return!document.body.classList.contains(o["toast-shown"])},B=function(e,t){return!!e.classList&&e.classList.contains(t)},E=function(e){if(e.focus(),"file"!==e.type){var t=e.value;e.value="",e.value=t}},P=function(e,t){if(e&&t){t.split(/\s+/).filter(Boolean).forEach(function(t){e.classList.add(t)})}},L=function(e,t){if(e&&t){t.split(/\s+/).filter(Boolean).forEach(function(t){e.classList.remove(t)})}},T=function(e,t){for(var n=0;n<e.childNodes.length;n++)if(B(e.childNodes[n],t))return e.childNodes[n]},q=function(e,t){t||(t=e===f()||e===x()?"flex":"block"),e.style.opacity="",e.style.display=t},V=function(e){e.style.opacity="",e.style.display="none"},O=function(e){return e.offsetWidth||e.offsetHeight||e.getClientRects().length},j=function(){var e=document.createElement("div"),t={WebkitAnimation:"webkitAnimationEnd",OAnimation:"oAnimationEnd oanimationend",animation:"animationend"};for(var n in t)if(t.hasOwnProperty(n)&&void 0!==e.style[n])return t[n];return!1}(),N="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&"function"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?"symbol":typeof e},M=Object.assign||function(e){for(var t=1;t<arguments.length;t++){var n=arguments[t];for(var o in n)Object.prototype.hasOwnProperty.call(n,o)&&(e[o]=n[o])}return e},H=M({},e),R=[];"undefined"==typeof Promise&&s("This package requires a Promise library, please include a shim to enable it in this browser (See: https://github.com/limonte/sweetalert2/wiki/Migration-from-SweetAlert-to-SweetAlert2#1-ie-support)");var I=function(e){for(var t in e)K.isValidParameter(t)||a('Unknown parameter "'+t+'"'),K.isDeprecatedParameter(t)&&function(e){-1===l.indexOf(e)&&(l.push(e),a(e))}('The parameter "'+t+'" is deprecated and will be removed in the next major release.')},D=function(t){("string"==typeof t.target&&!document.querySelector(t.target)||"string"!=typeof t.target&&!t.target.appendChild)&&(a('Target parameter is not valid, defaulting to "body"'),t.target="body");var n=void 0,i=f(),l="string"==typeof t.target?document.querySelector(t.target):t.target;n=i&&l&&i.parentNode!==l.parentNode?c(t):i||c(t),I(t);var u=t.width===e.width&&t.toast?"auto":t.width;n.style.width="number"==typeof u?u+"px":u;var d=t.padding===e.padding&&t.toast?"inherit":t.padding;n.style.padding="number"==typeof d?d+"px":d,n.style.background=t.background;for(var m=n.querySelectorAll("[class^=swal2-success-circular-line], .swal2-success-fix"),y=0;y<m.length;y++)m[y].style.background=t.background;var S=p(),A=b(),B=h(),E=x(),T=w(),O=C(),j=k();if(t.titleText?A.innerText=t.titleText:A.innerHTML=t.title.split("\n").join("<br />"),t.backdrop||P(document.body,o["no-backdrop"]),t.text||t.html){if("object"===N(t.html))if(B.innerHTML="",0 in t.html)for(var M=0;M in t.html;M++)B.appendChild(t.html[M].cloneNode(!0));else B.appendChild(t.html.cloneNode(!0));else t.html?B.innerHTML=t.html:t.text&&(B.textContent=t.text);q(B)}else V(B);if(t.position in o&&P(S,o[t.position]),t.grow&&"string"==typeof t.grow){var H="grow-"+t.grow;H in o&&P(S,o[H])}t.showCloseButton?(j.setAttribute("aria-label",t.closeButtonAriaLabel),q(j)):V(j),n.className=o.popup,t.toast?(P(document.body,o["toast-shown"]),P(n,o.toast)):P(n,o.modal),t.customClass&&P(n,t.customClass);var R=v(),D=parseInt(null===t.currentProgressStep?K.getQueueStep():t.currentProgressStep,10);t.progressSteps.length?(q(R),function(e){for(;e.firstChild;)e.removeChild(e.firstChild)}(R),D>=t.progressSteps.length&&a("Invalid currentProgressStep parameter, it should be less than progressSteps.length (currentProgressStep like JS arrays starts from 0)"),t.progressSteps.forEach(function(e,n){var r=document.createElement("li");if(P(r,o.progresscircle),r.innerHTML=e,n===D&&P(r,o.activeprogressstep),R.appendChild(r),n!==t.progressSteps.length-1){var i=document.createElement("li");P(i,o.progressline),i.style.width=t.progressStepsDistance,R.appendChild(i)}})):V(R);for(var U=f().querySelectorAll("."+o.icon),W=0;W<U.length;W++)V(U[W]);if(t.type){var z=!1;for(var Z in r)if(t.type===Z){z=!0;break}if(!z)return s("Unknown alert type: "+t.type),!1;var Q=n.querySelector("."+o.icon+"."+r[t.type]);if(q(Q),t.animation)switch(t.type){case"success":P(Q,"swal2-animate-success-icon"),P(Q.querySelector(".swal2-success-line-tip"),"swal2-animate-success-line-tip"),P(Q.querySelector(".swal2-success-line-long"),"swal2-animate-success-line-long");break;case"error":P(Q,"swal2-animate-error-icon"),P(Q.querySelector(".swal2-x-mark"),"swal2-animate-x-mark")}}var Y=g();t.imageUrl?(Y.setAttribute("src",t.imageUrl),Y.setAttribute("alt",t.imageAlt),q(Y),t.imageWidth?Y.setAttribute("width",t.imageWidth):Y.removeAttribute("width"),t.imageHeight?Y.setAttribute("height",t.imageHeight):Y.removeAttribute("height"),Y.className=o.image,t.imageClass&&P(Y,t.imageClass)):V(Y),t.showCancelButton?O.style.display="inline-block":V(O),t.showConfirmButton?function(e,t){e.style.removeProperty?e.style.removeProperty(t):e.style.removeAttribute(t)}(T,"display"):V(T),t.showConfirmButton||t.showCancelButton?q(E):V(E),T.innerHTML=t.confirmButtonText,O.innerHTML=t.cancelButtonText,T.setAttribute("aria-label",t.confirmButtonAriaLabel),O.setAttribute("aria-label",t.cancelButtonAriaLabel),t.buttonsStyling&&(T.style.backgroundColor=t.confirmButtonColor,O.style.backgroundColor=t.cancelButtonColor),T.className=o.confirm,P(T,t.confirmButtonClass),O.className=o.cancel,P(O,t.cancelButtonClass),t.buttonsStyling?(P(T,o.styled),P(O,o.styled)):(L(T,o.styled),L(O,o.styled),T.style.backgroundColor=T.style.borderLeftColor=T.style.borderRightColor="",O.style.backgroundColor=O.style.borderLeftColor=O.style.borderRightColor=""),!0===t.animation?L(n,o.noanimation):P(n,o.noanimation),t.showLoaderOnConfirm&&!t.preConfirm&&a("showLoaderOnConfirm is set to true, but preConfirm is not defined.\nshowLoaderOnConfirm should be used together with preConfirm, see usage example:\nhttps://limonte.github.io/sweetalert2/#ajax-request")},U=function(){null===u.previousBodyPadding&&document.body.scrollHeight>window.innerHeight&&(u.previousBodyPadding=document.body.style.paddingRight,document.body.style.paddingRight=function(){if("ontouchstart"in window||navigator.msMaxTouchPoints)return 0;var e=document.createElement("div");e.style.width="50px",e.style.height="50px",e.style.overflow="scroll",document.body.appendChild(e);var t=e.offsetWidth-e.clientWidth;return document.body.removeChild(e),t}()+"px")},W=function(){if(/iPad|iPhone|iPod/.test(navigator.userAgent)&&!window.MSStream&&!B(document.body,o.iosfix)){var e=document.body.scrollTop;document.body.style.top=-1*e+"px",P(document.body,o.iosfix)}},K=function e(){for(var t=arguments.length,n=Array(t),r=0;r<t;r++)n[r]=arguments[r];if(void 0===n[0])return s("SweetAlert2 expects at least 1 attribute!"),!1;var a=M({},H);switch(N(n[0])){case"string":a.title=n[0],a.html=n[1],a.type=n[2];break;case"object":if(M(a,n[0]),a.extraParams=n[0].extraParams,"email"===a.input&&null===a.inputValidator){var l=function(e){return new Promise(function(t,n){/^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/.test(e)?t():n("Invalid email address")})};a.inputValidator=a.expectRejections?l:e.adaptInputValidator(l)}if("url"===a.input&&null===a.inputValidator){var c=function(e){return new Promise(function(t,n){/^https?:\/\/(www\.)?[-a-zA-Z0-9@:%._+~#=]{2,256}\.[a-z]{2,6}\b([-a-zA-Z0-9@:%_+.~#?&//=]*)$/.test(e)?t():n("Invalid URL")})};a.inputValidator=a.expectRejections?c:e.adaptInputValidator(c)}break;default:return s('Unexpected type of argument! Expected "string" or "object", got '+N(n[0])),!1}D(a);var d=p(),m=f();return new Promise(function(t,n){var r=function(n){e.closePopup(a.onClose),t(a.useRejections?n:{value:n})},l=function(o){e.closePopup(a.onClose),a.useRejections?n(o):t({dismiss:o})},c=function(t){e.closePopup(a.onClose),n(t)};a.timer&&(m.timeout=setTimeout(function(){return l("timer")},a.timer));var M=function(e){if(!(e=e||a.input))return null;switch(e){case"select":case"textarea":case"file":return T(m,o[e]);case"checkbox":return m.querySelector("."+o.checkbox+" input");case"radio":return m.querySelector("."+o.radio+" input:checked")||m.querySelector("."+o.radio+" input:first-child");case"range":return m.querySelector("."+o.range+" input");default:return T(m,o.input)}};a.input&&setTimeout(function(){var e=M();e&&E(e)},0);for(var H=function(t){if(a.showLoaderOnConfirm&&e.showLoading(),a.preConfirm){var n=Promise.resolve().then(function(){return a.preConfirm(t,a.extraParams)});a.expectRejections?n.then(function(e){return r(e||t)},function(t){e.hideLoading(),t&&e.showValidationError(t)}):n.then(function(n){O(y())?e.hideLoading():r(n||t)},function(e){return c(e)})}else r(t)},R=function(t){var n=t||window.event,o=n.target||n.srcElement,r=w(),s=C(),u=r&&(r===o||r.contains(o)),d=s&&(s===o||s.contains(o));switch(n.type){case"mouseover":case"mouseup":a.buttonsStyling&&(u?r.style.backgroundColor=i(a.confirmButtonColor,-.1):d&&(s.style.backgroundColor=i(a.cancelButtonColor,-.1)));break;case"mouseout":a.buttonsStyling&&(u?r.style.backgroundColor=a.confirmButtonColor:d&&(s.style.backgroundColor=a.cancelButtonColor));break;case"mousedown":a.buttonsStyling&&(u?r.style.backgroundColor=i(a.confirmButtonColor,-.2):d&&(s.style.backgroundColor=i(a.cancelButtonColor,-.2)));break;case"click":if(u&&e.isVisible())if(e.disableButtons(),a.input){var p=function(){var e=M();if(!e)return null;switch(a.input){case"checkbox":return e.checked?1:0;case"radio":return e.checked?e.value:null;case"file":return e.files.length?e.files[0]:null;default:return a.inputAutoTrim?e.value.trim():e.value}}();if(a.inputValidator){e.disableInput();var f=Promise.resolve().then(function(){return a.inputValidator(p,a.extraParams)});a.expectRejections?f.then(function(){e.enableButtons(),e.enableInput(),H(p)},function(t){e.enableButtons(),e.enableInput(),t&&e.showValidationError(t)}):f.then(function(t){e.enableButtons(),e.enableInput(),t?e.showValidationError(t):H(p)},function(e){return c(e)})}else H(p)}else H(!0);else d&&e.isVisible()&&(e.disableButtons(),l("cancel"))}},I=m.querySelectorAll("button"),K=0;K<I.length;K++)I[K].onclick=R,I[K].onmouseover=R,I[K].onmouseout=R,I[K].onmousedown=R;k().onclick=function(){l("close")},a.toast?m.onclick=function(t){t.target!==m||a.showConfirmButton||a.showCancelButton||a.allowOutsideClick&&(e.closePopup(a.onClose),l("overlay"))}:d.onclick=function(e){e.target===d&&a.allowOutsideClick&&l("overlay")};var z=x(),Z=w(),Q=C();a.reverseButtons?Z.parentNode.insertBefore(Q,Z):Z.parentNode.insertBefore(Z,Q);var Y=function(e,t){for(var n=S(a.focusCancel),o=0;o<n.length;o++){(e+=t)===n.length?e=0:-1===e&&(e=n.length-1);var r=n[e];if(O(r))return r.focus()}},_=function(t){var n=t||window.event;if("Enter"===n.key)n.target===M()&&(e.clickConfirm(),n.preventDefault());else if("Tab"===n.key){for(var o=n.target||n.srcElement,r=S(a.focusCancel),i=-1,s=0;s<r.length;s++)if(o===r[s]){i=s;break}n.shiftKey?Y(i,-1):Y(i,1),n.stopPropagation(),n.preventDefault()}else-1!==["ArrowLeft","ArrowRight","ArrowUp","ArrowDown","Left","Right","Up","Down"].indexOf(n.key)?document.activeElement===Z&&O(Q)?Q.focus():document.activeElement===Q&&O(Z)&&Z.focus():"Escape"!==n.key&&"Esc"!==n.key||!0!==a.allowEscapeKey||l("esc")};window.onkeydown&&window.onkeydown.toString()===_.toString()||(u.previousWindowKeyDown=window.onkeydown,window.onkeydown=_),a.buttonsStyling&&(Z.style.borderLeftColor=a.confirmButtonColor,Z.style.borderRightColor=a.confirmButtonColor),e.hideLoading=e.disableLoading=function(){a.showConfirmButton||(V(Z),a.showCancelButton||V(x())),L(z,o.loading),L(m,o.loading),m.removeAttribute("aria-busy"),Z.disabled=!1,Q.disabled=!1},e.getTitle=function(){return b()},e.getContent=function(){return h()},e.getInput=function(){return M()},e.getImage=function(){return g()},e.getButtonsWrapper=function(){return x()},e.getConfirmButton=function(){return w()},e.getCancelButton=function(){return C()},e.enableButtons=function(){Z.disabled=!1,Q.disabled=!1},e.disableButtons=function(){Z.disabled=!0,Q.disabled=!0},e.enableConfirmButton=function(){Z.disabled=!1},e.disableConfirmButton=function(){Z.disabled=!0},e.enableInput=function(){var e=M();if(!e)return!1;if("radio"===e.type)for(var t=e.parentNode.parentNode.querySelectorAll("input"),n=0;n<t.length;n++)t[n].disabled=!1;else e.disabled=!1},e.disableInput=function(){var e=M();if(!e)return!1;if(e&&"radio"===e.type)for(var t=e.parentNode.parentNode.querySelectorAll("input"),n=0;n<t.length;n++)t[n].disabled=!0;else e.disabled=!0},e.showValidationError=function(e){var t=y();t.innerHTML=e,q(t);var n=M();n&&(n.setAttribute("aria-invalid",!0),n.setAttribute("aria-describedBy",o.validationerror),E(n),P(n,o.inputerror))},e.resetValidationError=function(){var e=y();V(e);var t=M();t&&(t.removeAttribute("aria-invalid"),t.removeAttribute("aria-describedBy"),L(t,o.inputerror))},e.getProgressSteps=function(){return a.progressSteps},e.setProgressSteps=function(e){a.progressSteps=e,D(a)},e.showProgressSteps=function(){q(v())},e.hideProgressSteps=function(){V(v())},e.enableButtons(),e.hideLoading(),e.resetValidationError(),a.input&&P(document.body,o["has-input"]);for(var $=["input","file","range","select","radio","checkbox","textarea"],J=void 0,X=0;X<$.length;X++){var F=o[$[X]],G=T(m,F);if(J=M($[X])){for(var ee in J.attributes)if(J.attributes.hasOwnProperty(ee)){var te=J.attributes[ee].name;"type"!==te&&"value"!==te&&J.removeAttribute(te)}for(var ne in a.inputAttributes)J.setAttribute(ne,a.inputAttributes[ne])}G.className=F,a.inputClass&&P(G,a.inputClass),V(G)}var oe=void 0;switch(a.input){case"text":case"email":case"password":case"number":case"tel":case"url":(J=T(m,o.input)).value=a.inputValue,J.placeholder=a.inputPlaceholder,J.type=a.input,q(J);break;case"file":(J=T(m,o.file)).placeholder=a.inputPlaceholder,J.type=a.input,q(J);break;case"range":var re=T(m,o.range),ie=re.querySelector("input"),ae=re.querySelector("output");ie.value=a.inputValue,ie.type=a.input,ae.value=a.inputValue,q(re);break;case"select":var se=T(m,o.select);if(se.innerHTML="",a.inputPlaceholder){var le=document.createElement("option");le.innerHTML=a.inputPlaceholder,le.value="",le.disabled=!0,le.selected=!0,se.appendChild(le)}oe=function(e){for(var t in e){var n=document.createElement("option");n.value=t,n.innerHTML=e[t],a.inputValue.toString()===t&&(n.selected=!0),se.appendChild(n)}q(se),se.focus()};break;case"radio":var ue=T(m,o.radio);ue.innerHTML="",oe=function(e){for(var t in e){var n=document.createElement("input"),r=document.createElement("label"),i=document.createElement("span");n.type="radio",n.name=o.radio,n.value=t,a.inputValue.toString()===t&&(n.checked=!0),i.innerHTML=e[t],r.appendChild(n),r.appendChild(i),r.for=n.id,ue.appendChild(r)}q(ue);var s=ue.querySelectorAll("input");s.length&&s[0].focus()};break;case"checkbox":var ce=T(m,o.checkbox),de=M("checkbox");de.type="checkbox",de.value=1,de.id=o.checkbox,de.checked=Boolean(a.inputValue);var pe=ce.getElementsByTagName("span");pe.length&&ce.removeChild(pe[0]),(pe=document.createElement("span")).innerHTML=a.inputPlaceholder,ce.appendChild(pe),q(ce);break;case"textarea":var fe=T(m,o.textarea);fe.value=a.inputValue,fe.placeholder=a.inputPlaceholder,q(fe);break;case null:break;default:s('Unexpected type of input! Expected "text", "email", "password", "number", "tel", "select", "radio", "checkbox", "textarea", "file" or "url", got "'+a.input+'"')}"select"!==a.input&&"radio"!==a.input||(a.inputOptions instanceof Promise?(e.showLoading(),a.inputOptions.then(function(t){e.hideLoading(),oe(t)})):"object"===N(a.inputOptions)?oe(a.inputOptions):s("Unexpected type of inputOptions! Expected object or Promise, got "+N(a.inputOptions))),function(e,t,n){var r=p(),i=f();null!==t&&"function"==typeof t&&t(i),e?(P(i,o.show),P(r,o.fade),L(i,o.hide)):L(i,o.fade),q(i),r.style.overflowY="hidden",j&&!B(i,o.noanimation)?i.addEventListener(j,function e(){i.removeEventListener(j,e),r.style.overflowY="auto"}):r.style.overflowY="auto",P(document.documentElement,o.shown),P(document.body,o.shown),P(r,o.shown),A()&&(U(),W()),u.previousActiveElement=document.activeElement,null!==n&&"function"==typeof n&&setTimeout(function(){n(i)})}(a.animation,a.onBeforeOpen,a.onOpen),a.toast||(a.allowEnterKey?a.focusCancel&&O(Q)?Q.focus():a.focusConfirm&&O(Z)?Z.focus():Y(-1,1):document.activeElement&&document.activeElement.blur()),p().scrollTop=0})};return K.isVisible=function(){return!!f()},K.queue=function(e){R=e;var t=function(){R=[],document.body.removeAttribute("data-swal2-queue-step")},n=[];return new Promise(function(e,o){!function r(i,a){i<R.length?(document.body.setAttribute("data-swal2-queue-step",i),K(R[i]).then(function(e){n.push(e),r(i+1,a)},function(e){t(),o(e)})):(t(),e(n))}(0)})},K.getQueueStep=function(){return document.body.getAttribute("data-swal2-queue-step")},K.insertQueueStep=function(e,t){return t&&t<R.length?R.splice(t,0,e):R.push(e)},K.deleteQueueStep=function(e){void 0!==R[e]&&R.splice(e,1)},K.close=K.closePopup=K.closeModal=K.closeToast=function(e){var t=p(),n=f();if(n){L(n,o.show),P(n,o.hide),clearTimeout(n.timeout),document.body.classList.contains(o["toast-shown"])||function(){if(window.onkeydown=u.previousWindowKeyDown,u.previousActiveElement&&u.previousActiveElement.focus){var e=window.scrollX,t=window.scrollY;u.previousActiveElement.focus(),e&&t&&window.scrollTo(e,t)}}();var r=function(){t.parentNode&&t.parentNode.removeChild(t),L(document.documentElement,o.shown),L(document.body,o.shown),L(document.body,o["no-backdrop"]),L(document.body,o["has-input"]),L(document.body,o["toast-shown"]),A()&&(null!==u.previousBodyPadding&&(document.body.style.paddingRight=u.previousBodyPadding,u.previousBodyPadding=null),function(){if(B(document.body,o.iosfix)){var e=parseInt(document.body.style.top,10);L(document.body,o.iosfix),document.body.style.top="",document.body.scrollTop=-1*e}}())};j&&!B(n,o.noanimation)?n.addEventListener(j,function e(){n.removeEventListener(j,e),B(n,o.hide)&&r()}):r(),null!==e&&"function"==typeof e&&setTimeout(function(){e(n)})}},K.clickConfirm=function(){return w().click()},K.clickCancel=function(){return C().click()},K.showLoading=K.enableLoading=function(){var e=f();e||K(""),e=f();var t=x(),n=w(),r=C();q(t),q(n,"inline-block"),P(t,o.loading),P(e,o.loading),n.disabled=!0,r.disabled=!0,e.setAttribute("aria-busy",!0),e.focus()},K.isValidParameter=function(t){return e.hasOwnProperty(t)||"extraParams"===t},K.isDeprecatedParameter=function(e){return-1!==t.indexOf(e)},K.setDefaults=function(e){if(!e||"object"!==(void 0===e?"undefined":N(e)))return s("the argument for setDefaults() is required and has to be a object");I(e);for(var t in e)K.isValidParameter(t)&&(H[t]=e[t])},K.resetDefaults=function(){H=M({},e)},K.adaptInputValidator=function(e){return function(t,n){return e.call(this,t,n).then(function(){},function(e){return e})}},K.noop=function(){},K.version="7.0.0",K.default=K,K}),window.Sweetalert2&&(window.sweetAlert=window.swal=window.Sweetalert2);