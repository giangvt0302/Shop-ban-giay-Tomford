package com.shop.tomford.file.command.uploadFile;

import com.shop.tomford.common.Cqrs.HandleResponse;
import com.shop.tomford.common.Cqrs.IRequestHandler;
import com.shop.tomford.file.IFileService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UploadFileCommandHandler implements IRequestHandler<UploadFileCommand, String> {
    private final IFileService fileService;

    @Override
    public HandleResponse<String> handle(UploadFileCommand uploadFileCommand) {
        try {
            return HandleResponse.ok(fileService.uploadFile(uploadFileCommand.getFile()));
        } catch (Exception e) {
            return HandleResponse.error(e.getMessage());
        }
    }
}
