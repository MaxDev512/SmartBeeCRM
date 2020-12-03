1. View 使用 FreeMarker
2. Database ORM 使用 Hibernate JPA，資料庫檔路徑放至 ~/
3. 採用 MVC 加 Service 的架構
4. 分為五大元件，分別為 AuthFilter、AuthController、FunctionController、CompanyController、ClientController
5. AuthFilter/AuthController 處理登入、登出和安全性相關功能
6. FunctionController 顯示功能頁
7. CompanyController 處理 Company 相關功能
8. ClientController 處理 Client 相關功能
9. UserRepository、CompanyRepository、ClientRepository 分別處理 使用者、Company、Client 資料庫相關操作
10. constant package 放置常數相關
11. com.exam.crm.CrmApplicationTests 為測試相關
12. 測試帳號/密碼/權限：
    - max/1234/Super user
    - max2/1234/Mamager
    - max3/1234/Operator