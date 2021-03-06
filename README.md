# play2.3-webapi-stub

play2.3-webapi-stub は、 [Play Framework 2.3](https://www.playframework.com/documentation/ja/2.3.x/Home) で構築されたWebAPIのスタブアプリです。<br />
URLで指定されたエンドポイントより、データベースで紐づくレスポンスを返却します。<br />
レスポンスはすべてjsonを想定しています。

<br /><br />


## ビルド方法

開発環境構築方法、また起動方法について解説します。<br />
※本項は、下記セットアップが完了していることを前提としています。

- Javaセットアップ（JDK 1.8.x）
- activatorコマンドセットアップ
    - [Play のインストール](https://www.playframework.com/documentation/ja/2.3.x/Installing)
- データベースセットアップ（MySQL 5.6.x）

<br /><br />


### 開発環境構築方法
#### ●アプリケーションセットアップ

アプリケーションをクローンします。
```
$ git clone https://github.com/tomo-sato/play2.3-webapi-stub.git
```

アプリケーションフォルダに移動し、 eclipse でインポート可能なプロジェクト構成にします。
```
$ cd play2.3-webapi-stub
$ activator eclipse
```

eclipse よりプロジェクトをインポートします。

<br /><br />


#### ●DBセットアップ

DDLを実行します。
- [00_create_db_ddl.sql](https://github.com/tomo-sato/play2.3-webapi-stub/blob/master/doc/ddl/00_create_db_ddl.sql)
    - データベース、ユーザの作成。
- [01_create_table_ddl.sql](https://github.com/tomo-sato/play2.3-webapi-stub/blob/master/doc/ddl/01_create_table_ddl.sql)
    - テーブルの作成。

※以前のバージョンからテーブルを更新する場合は、以下のupdate用ddlを参照ください。バージョンごとにddlをアップしています。
- [update用ddl保存フォルダ](https://github.com/tomo-sato/play2.3-webapi-stub/blob/master/doc/ddl/update_ddl)

ER図<br />
![play2.3-webapi-stub.png](https://tomo-sato.github.io/play2.3-webapi-stub/doc/erd/play2.3-webapi-stub.png "play2.3-webapi-stub.png")

<br /><br />


### 起動方法

アプリケーションがクローンされていること、DBセットアップが完了していることを前提とします。

アプリケーションフォルダに移動し、起動スクリプトを実行します。
```
$ cd play2.3-webapi-stub
$ sh ./local.sh
```
（※Windows用起動スクリプトは `local.bat` を用意しています。）<br />

[http://localhost:9001/](http://localhost:9001/) にアクセスすると<br />
「Your new application is ready.」と表示されればセットアップ完了です。

<br /><br />


## ドキュメント

- [play2.3-webapi-stub アプリケーションベース API仕様](https://tomo-sato.github.io/play2.3-webapi-stub/doc/JavaDoc/index.html)

<br /><br />


## リリースノート

- [1.3.0 2017/11/07 レスポンスを編集できるよう機能追加。](https://github.com/tomo-sato/play2.3-webapi-stub/releases/tag/play2.3-webapi-stub_1.3.0)
    - レスポンスを編集できるよう機能追加。
    - レスポンスを選択できるよう機能追加。
- [1.2.0 2017/09/19 レスポンス時間を任意で調整する機能追加。](https://github.com/tomo-sato/play2.3-webapi-stub/releases/tag/play2.3-webapi-stub_1.2.0)
    - レスポンス時間を任意で調整するパラメータ追加。
- [1.1.0 2017/09/19 スタブAPI一覧表示画面作成。](https://github.com/tomo-sato/play2.3-webapi-stub/releases/tag/play2.3-webapi-stub_1.1.0)
    - スタブAPIの一覧画面作成。
    - スタブAPIの詳細画面作成。
- [1.0.0 2017/09/18 初回リリース。](https://github.com/tomo-sato/play2.3-webapi-stub/releases/tag/play2.3-webapi-stub_1.0.0)
    - スタブAPIの作成。

<br /><br />


## ライセンス
Copyright 2017 tomo-sato This software is licensed under the Apache 2 license, quoted below.

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this project except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0.

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
