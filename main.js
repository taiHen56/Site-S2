var splide = new Splide(".splide", {
  type: "loop",
  drag: "free",
  snap: true,
  perPage: 8,
});

splide.mount();

function voirPlus(){
  var ligne = document.getElementById("voir");
  var btn = document.getElementById("btnVoir");

  if (ligne.style.visibility === "collapse") {
    ligne.style.visibility="visible";
    btn.innerHTML="Montrer moins...";
  } else {
    ligne.style.visibility="collapse";
    btn.innerHTML="Montrer plus...";

  }
}

function ariane(){
  var para1 = document.getElementById("cate");
  var para2 = document.getElementById("actived");
  var ariane = document.getElementById("courant");
  para1.classList.add("actived");
  para2.classList.remove("actived");
  ariane.innerHTML=para1.innerHTML;

  para1.onclick=ariane;
}

