1操作模式(命令模式)(按esc键进入)(如果不确 定自己在什么模式，多按几下esc)
```
  o 可以在光标下面新建一行(不论在该行的那个位置)
	O 在光标上面新建一行
 	u 
	. 把撤销的动作重做一遍/重复上一步命令，减少重复操作
	a 在光标后面插入
	A 在当前行的末尾输入文本
	i 进入编辑模式，在光标前面插入
	I 在当前行输入文本 
	
	gg 文章开头
	G 文末
	nG 调转到第n行
	yw 将从光标开始往后到空格为止(包含空格)复制(之后仍处于命令模式)
	Y 将从光标开始到行末的所有字符复制(之后仍处于命令模式)
	y$ 同Y
	yy 复制当前行    
	nyy 复制从当前行开始数n行
	x 将光标显示的字符移到缓冲区(之后仍处于命令模式)
	X 将光标显示的光标之前的字符移到缓冲区(之后仍处于命令模式)
	dw 将从光标开始往后到空格为止(包含空格)移到缓冲区(之后仍处于命令模式)
	dG 将光标所在行到文末的所有行删除
	cw 将从光标开始往后到空格为止(包含空格)移到缓冲区，之后进入编辑模式
	ce 同cw	
	cb 将从光标开始往前到空格为止(包含空格)移到缓冲区，之后可以直接输入新的文本
	d$ 将从光标开始到行末的所有字符移到缓冲区(之后仍处于命令模式)
	D 同d$
	c$ 将从光标开始到行末的所有字符移到缓冲区，之后进入编辑模式 
	C 同c$
	dd 将当前行移到缓冲区(剪切操作)(之后仍处于命令模式)
	ndd 将从当前行往后开始数n行移到缓冲区
	cc 将当前行移到缓冲区(剪切操作)，之后进入编辑模式
	ncc 将从当前行往后开始数n行移到缓冲区,之后进入编辑模式	
	p 光标下一行开始粘贴一行/光标之后字符串
	P 光标上一行开始粘贴一行/光标之前字符串
	r 替换单个字符，光标显示的那个
	R 一直替换字符，直到按esc截至
	/ 查找字符
	n 显示搜索命令定位到的下一个字符串
	N 显示搜索结果定位到的上一个字符串
	b 光标移动到当前单词/上一个单词的开始
	w 光标移动到下一个单词的开始
	e 光标移动到当前单词/下一个单词的末尾

	ZZ 同末行命令模式下的 :wq
	
	$ 调转到行尾
	0 调转至行首
```
	
2编辑模式
```
  <C-u> 撤销
```
  
3末行命令模式(这些操作如设置快捷键等退出之后再次进入就不管用了，若要永久起作用就写配置文件)
```
  : 进入末行命令行模式
	:w 相当于<C-s>
	:w filename
	:w!
	:w! filename
	:q
	:q!
	:wq
	:wq!		不是所有人都可以使用，只有文件所有者与root才能在文件仅r--的情况下使用
	:set nu 	显示行号
	:set nonu 	不显示行号
	:n 		调转到改行
	:n1,n2d 	删除从n1到n2的行
	:e! 		撤销到上一次保存的结果
	:e filename 	创建新文件，在同一个目录
	:n filename 	加载其他文件，在同一个目录
	:w filename	另存为一个新的文件
	:%s/要替换的字符串/新的字符串g 		全文替换 
	:n1,n2s/要替换的字符串/新的字符串/g 	在n1到n2之间替换，不询问
		:1,4s/^/#/g			在1到4行的行首插入#
	:n1,n2s/要替换的字符串/新的字符串/c 	在n1到n2之间替换，询问
	:r /etc/issue 	在光标处导入一个新文件
 	:!命令		在不退出vi的情况下执行命令
		结合使用:r !date 可将文本编辑时间直接输入到光标所在位置
	:map <C-v-p> I#<ESC> 	ctrl加上v在加上需要定义的快捷键(这里举例是p)定义该快捷键是等价于在命令模式将每一行行首添加一个#
		:map <C-v-h> iyangbingxue19990502@gmail.com<ESC> 定义插入邮箱地址,并退回到命令模式 
	:ab mymail yangbingxue19990502@gamil.com 	在文中将mymail替换成yangbingxue19990502@gmail.com 只要敲击完之后按“Space”或者"Enter"就会替换
	:unab mymail 	取消mymail关联
```

4永久生效
```
在用户的家目录下创建.vimrc将操作写入即可(里面只能放一些编辑模式的命令)
	#> vi /root/.vimrc	(针对root用户)
		set nu 		设置行号
		map ^p I#<ESC>	定义快捷键
	#> vi /home/Tony/.vimrc	(针对普通用户Tony)
```

1.同一文件内文本的复制与粘贴
```
esc进入操作模式，在复制的那一行按两次y
需要在光标上一行粘贴按P(shift+p)
需要在光标下一行粘贴按p
```
