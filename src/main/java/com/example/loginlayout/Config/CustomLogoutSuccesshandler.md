@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                Authentication authentication) throws IOException, ServletException {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // 세션 제거
        }

        response.sendRedirect("/login"); // 로그인 페이지로 이동
    }
}
