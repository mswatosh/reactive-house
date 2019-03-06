function main() {
    var c = document.getElementById("houseCanvas");
    var ctx = c.getContext("2d");
    ctx.beginPath();
    ctx.arc(95, 50, 40, 0, 2 * Math.PI);
    
    var file = new File("img/circle.svg");
    console.log(file.exists());
    
    ctx.drawImage("img/circle.svg",0,0);
    ctx.stroke(); 

    
} 