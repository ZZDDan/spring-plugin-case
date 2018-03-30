location / {
    root /home/wwwroot/Web_UI;
    index index.html index.htm;
    if (-f $request_filename) {
        root /home/wwwroot/Web_UI;
        expires 30d;
        break;
    }
    if ( !-e $request_filename) {
        proxy_pass http://127.0.0.1:8088;
    }
}

location / {
# root   html;
# index  index.html index.htm;

}