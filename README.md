头条的适配方式 

 implementation 'com.github.a450479378:TouTiaoShiPei:0.0.3'


在application里调
AutoScreenUtils.DEFAULT_STANDARD=360;
AutoScreenUtils.AdjustDensity(Application application);

就能把所有机型的宽度都变成360dp
文字用dp为单位也能适配不同dpi机型

就是18:9比16:9的屏幕多一块





