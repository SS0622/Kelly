<%-- 担当: 平間 --%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/header.html" %>
<title>LegalGraffiti -キャンバス-</title>
<link rel="stylesheet" href="css/canvas.css"/>
</head>
<body>
<%--メッセージの出力  --%>

<form action="Logout.action" method="post">
	<div id="canvas_area">
		<canvas>
			<nav id="pallet">
				<label for="colorPicker">Color:</label>
				<input type="color" id="colorPicker">
				<label for="lineWidthRange">Line Width:</label>
				<input type="range" id="lineWidthRange" min="1" max="20" value="5">
			</nav>
			<canvas id="picture" width="${width}" height="${height}"></canvas>
			<button id="clearBtn">リセット</button>
			<button id="saveBtnUsingDownload">ライブラリーに保存して戻る</button>
			<hr>		
		</canvas>
	</div>
</form>
<script>
class CanvasDrawer {
    constructor(canvasId) {
        this.canvas = document.getElementById(canvasId);
        this.ctx = this.canvas.getContext('2d');
        //this.header = document.querySelector('header');
        this.painting = false;
        this.lastMousePos = { x: 0, y: 0 };

        this.updateCanvasPosition();
        window.addEventListener('scroll', this.updateCanvasPosition.bind(this));

        this.canvas.addEventListener('mousedown', this.startPosition.bind(this));
        this.canvas.addEventListener('mouseup', this.endPosition.bind(this));
        this.canvas.addEventListener('mousemove', this.draw.bind(this));
        
        this.color = '#000000'; // デフォルトの色を設定
        this.lineWidth = 5; // デフォルトの線幅を設定
    }

    updateCanvasPosition() {
        const rect = this.canvas.getBoundingClientRect();
        this.offsetX = rect.left + window.scrollX;
        this.offsetY = rect.top + window.scrollY;
    }

    draw(e) {
        if (!this.painting) return;

        const currentMousePos = this.getMousePosition(e);
        this.ctx.lineWidth = this.lineWidth;
        this.ctx.lineCap = 'round';
        this.ctx.strokeStyle = this.color;
        this.ctx.beginPath();
        this.ctx.moveTo(this.lastMousePos.x, this.lastMousePos.y);
        this.ctx.lineTo(currentMousePos.x, currentMousePos.y);
        this.ctx.stroke();
        this.lastMousePos = currentMousePos;
    }

    getMousePosition(e) {
        return {
            x: e.clientX - this.offsetX + window.scrollX,
            y: e.clientY - this.offsetY + window.scrollY
        };
    }

    disableHeaderLinks() {
        const links = this.header.querySelectorAll('a');
        links.forEach(link => {
            link.style.pointerEvents = 'none';
        });
    }

    enableHeaderLinks() {
        const links = this.header.querySelectorAll('a');
        links.forEach(link => {
            link.style.pointerEvents = 'auto';
        });
    }

    setColor(color) {
        this.color = color;
        this.ctx.strokeStyle = color;
    }

    setLineWidth(width) {
        this.lineWidth = width;
    }

    clearCanvas() {
        this.ctx.clearRect(0, 0, this.canvas.width, this.canvas.height);
    }

    //作った画像をダウンロード
    saveImageUsingDownload() {
        const link = document.createElement('a');
        link.download = 'canvas_image.png';
        link.href = this.canvas.toDataURL();
        link.click();
    }

document.addEventListener("DOMContentLoaded", function() {
    const drawer = new CanvasDrawer('picture');

    document.getElementById('clearBtn').addEventListener('click', function() {
        drawer.clearCanvas();
    });

    document.getElementById('saveBtnUsingDownload').addEventListener('click', function() {
        drawer.saveImageUsingDownload();
    });

    document.getElementById('colorPicker').addEventListener('input', function(e) {
        const color = e.target.value;
        drawer.setColor(color);
    });

    document.getElementById('lineWidthRange').addEventListener('input', function(e) {
        const width = e.target.value;
        drawer.setLineWidth(width);
    });

});
</script>

<%@include file="../common/footer.html" %>
